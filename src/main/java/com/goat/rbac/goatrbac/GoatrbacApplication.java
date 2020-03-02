package com.goat.rbac.goatrbac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.goat.rbac.goatrbac.buzz.dao","com.goat.rbac.goatrbac.system.dao"})
public class GoatrbacApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoatrbacApplication.class, args);
    }

}
