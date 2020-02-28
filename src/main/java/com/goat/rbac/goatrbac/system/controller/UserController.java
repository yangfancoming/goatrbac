package com.goat.rbac.goatrbac.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("user")
    @RequiresPermissions("user:list")
    public String index(Model model) {
        User user = getCurrentUser();
        model.addAttribute("user", user);
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

    @RequiresPermissions("user:add")
    @PostMapping("user/add")
    @ResponseBody
    public ResponseBo addUser(User user, Long[] roles) {
        try {
            String status = "on".equalsIgnoreCase(user.getStatus())?"1":"0";
            user.setStatus(status);
            userService.addUser(user, roles);
            return ResponseBo.ok("新增用户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增用户失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("user/delete")
    @ResponseBody
    public ResponseBo deleteByIds(String ids) {
        try {
            String[] split = ids.split(",");
            userService.deleteByIds(split);
            return ResponseBo.ok("删除用户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除用户失败，请联系网站管理员！");
        }
    }

    @RequestMapping("user/getUser")
    @ResponseBody
    public ResponseBo getUser(Long userId) {
        try {
            User user = userService.findUserOne(new User(userId));
            return ResponseBo.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取用户信息失败，请联系网站管理员！");
        }
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
