package com.goat.rbac.goatrbac.system.config;

import com.goat.rbac.goatrbac.system.dialect.SysDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2020/8/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/8/25---12:51
 */
@Configuration
public class ThymeleafDialectConfig {

    /**
     * 系统方言
     * 主要作用有：
     * 1. 处理字典数据展示
     *
     * @return
     */
    @Bean
    public SysDialect sysDialect() {
        return new SysDialect();
    }
}