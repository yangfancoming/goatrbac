package com.goat.rbac.goatrbac;

import com.goat.rbac.goatrbac.system.dao.UserMapper;
import com.goat.rbac.goatrbac.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        return "Hello ";
    }

    @GetMapping("/hello2")
    public void hello2() {
        User user = new User();
        user.setUserId(4L);
        User userProfile = userMapper.findUserProfile(user);

        System.out.println(userProfile);
    }

}