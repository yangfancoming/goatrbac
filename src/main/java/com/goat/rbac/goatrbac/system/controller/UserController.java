package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

    @RequestMapping("user/profile")
    public String profileIndex(Model model) {
        User user = super.getCurrentUser();
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
