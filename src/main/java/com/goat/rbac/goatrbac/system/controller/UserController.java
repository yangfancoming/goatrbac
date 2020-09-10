package com.goat.rbac.goatrbac.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.model.UserWithRole;
import com.goat.rbac.goatrbac.system.service.IUserRoleService;
import com.goat.rbac.goatrbac.system.service.IUserService;
import com.goat.rbac.goatrbac.system.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping("list")
    public Map<String, Object> list(QueryRequest request, User user) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<User> list = userService.findUserWithDept(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    public ResponseBo add(User user, Long[] roles) {
        String status = "on".equalsIgnoreCase(user.getStatus())?"1":"0";
        user.setStatus(status);
        userService.addUser(user, roles);
        return ResponseBo.ok("新增用户成功！");
    }

    @RequestMapping("delete")
    public ResponseBo delete(String ids) {
        userService.deleteByIds(ids.split(","));
        return ResponseBo.ok("删除用户成功！");
    }

    @RequestMapping("getUser")
    public ResponseBo getUser(Long userId) {
        UserWithRole userWithRole = userRoleService.findUserWithRole(new User(userId));
        return ResponseBo.ok(userWithRole);
    }

    @RequestMapping("update")
    public ResponseBo update(User user, Long[] rolesSelect) {
        if ("on".equalsIgnoreCase(user.getStatus()))
            user.setStatus("1");
        else
            user.setStatus("0");
        userService.update(user, rolesSelect);
        return ResponseBo.ok("修改用户成功！");
    }


    @RequestMapping("checkUserName")
    public boolean checkUserName(String username, String oldusername) {
        if (!StringUtils.isEmpty(oldusername) && username.equalsIgnoreCase(oldusername)) {
            return true;
        }
        User result = userService.findByName(username);
        if (result != null)
            return false;
        return true;
    }

//    @RequestMapping("profile")
//    public String profileIndex(Model model) {
//        User user = getCurrentUser();
//        user = userService.findUserProfile(user);
//        String ssex = user.getSsex();
//        if ("0".equals(ssex)) {
//            user.setSsex("性别：男");
//        } else if ("1".equals(ssex)) {
//            user.setSsex("性别：女");
//        } else {
//            user.setSsex("性别：保密");
//        }
//        model.addAttribute("user", user);
//        return "system/user/profile";
//    }

//    @RequestMapping("getUserProfile")
//    public ResponseBo getUserProfile(Long userId) {
//        try {
//            User user = new User();
//            user.setUserId(userId);
//            return ResponseBo.ok(this.userService.findUserProfile(user));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseBo.error("获取用户信息失败，请联系网站管理员！");
//        }
//    }

    @RequestMapping("checkPassword")
    public boolean checkPassword(String password) {
        User user = getCurrentUser();
        String encrypt = MD5Utils.encrypt(user.getUsername().toLowerCase(), password);
        if (user.getPassword().equals(encrypt))
            return true;
        return false;
    }

    @RequestMapping("updatePassword")
    public ResponseBo updatePassword(String newPassword) {
        userService.updatePassword(newPassword);
        return ResponseBo.ok("更改密码成功！");
    }
}
