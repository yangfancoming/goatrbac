package com.goat.rbac.goatrbac.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.model.UserWithRole;
import com.goat.rbac.goatrbac.system.service.IUserRoleService;
import com.goat.rbac.goatrbac.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping("user")
    public String index(Model model) {
        model.addAttribute("user", getCurrentUser());
        return "system/user/user";
    }

    @RequestMapping("user/list")
    @ResponseBody
    public Map<String, Object> userList(QueryRequest request, User user) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<User> list = userService.findUserWithDept(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    @PostMapping("user/add")
    @ResponseBody
    public ResponseBo addUser(User user, Long[] roles) {
        String status = "on".equalsIgnoreCase(user.getStatus())?"1":"0";
        user.setStatus(status);
        userService.addUser(user, roles);
        return ResponseBo.ok("新增用户成功！");
    }

    @RequestMapping("user/delete")
    @ResponseBody
    public ResponseBo deleteByIds(String ids) {
        userService.deleteByIds(ids.split(","));
        return ResponseBo.ok("删除用户成功！");
    }

    @RequestMapping("user/getUser")
    @ResponseBody
    public ResponseBo getUser(Long userId) {
        UserWithRole userWithRole = userRoleService.findUserWithRole(new User(userId));
        return ResponseBo.ok(userWithRole);
    }

    @RequestMapping("user/update")
    @ResponseBody
    public ResponseBo updateUser(User user, Long[] rolesSelect) {
        if ("on".equalsIgnoreCase(user.getStatus()))
            user.setStatus("1");
        else
            user.setStatus("0");
        userService.update(user, rolesSelect);
        return ResponseBo.ok("修改用户成功！");
    }


    @RequestMapping("user/checkUserName")
    @ResponseBody
    public boolean checkUserName(String username, String oldusername) {
        if (!StringUtils.isEmpty(oldusername) && username.equalsIgnoreCase(oldusername)) {
            return true;
        }
        User result = userService.findByName(username);
        if (result != null)
            return false;
        return true;
    }

    @RequestMapping("user/profile")
    public String profileIndex(Model model) {
        User user = getCurrentUser();
        user = userService.findUserProfile(user);
        String ssex = user.getSsex();
        if ("0".equals(ssex)) {
            user.setSsex("性别：男");
        } else if ("1".equals(ssex)) {
            user.setSsex("性别：女");
        } else {
            user.setSsex("性别：保密");
        }
        model.addAttribute("user", user);
        return "system/user/profile";
    }
}
