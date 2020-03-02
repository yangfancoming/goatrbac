package com.goat.rbac.goatrbac.system.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/dept").setViewName("system/dept/dept");
        registry.addViewController("/role").setViewName("system/role/role");
        registry.addViewController("/dict").setViewName("system/dict/dict");
        registry.addViewController("/menu").setViewName("system/menu/menu");
        registry.addViewController("/").setViewName("redirect:/index"); // sos  shiro退出后会请求到这里需要重定向下 否则页面报错 用户不存在。

        registry.addViewController("/device").setViewName("buzz/device/device");
    }

}

