package com.goat.rbac.goatrbac.system.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    // 将该方法返回值 放入spring容器环境 其在容器中的名称为 securityManager（方法名）
    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm){
        // 1. 创建 DefaultWebSecurityManager 对象
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        // 2.securityManager 关联 自定义realm
        securityManager.setRealm(shiroRealm);
        // 3. 设置记住我功能
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    // 创建 ShiroFilterFactoryBean 并与 securityManager 进行关联
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroBean = new ShiroFilterFactoryBean();
        shiroBean.setSecurityManager(securityManager);
        shiroBean.setLoginUrl("/login");
        shiroBean.setSuccessUrl("/index");
        shiroBean.setUnauthorizedUrl("/403");
        shiroBean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());//  加载url拦截规则
        return shiroBean;
    }

    /**
     对于登录请求，Filter直接放过，进到controller里面。Controller会调用shiro做用户名和密码的校验，成功后返回token
     */
    @Bean
    protected ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition(); // 为了保证顺序 使用 LinkedHashMap
        chainDefinition.addPathDefinition("/css/**", "anon");
        chainDefinition.addPathDefinition("/js/**", "anon");
        chainDefinition.addPathDefinition("/fonts/**", "anon");
        chainDefinition.addPathDefinition("/img/**", "anon");
        chainDefinition.addPathDefinition("/druid/**", "anon");
        chainDefinition.addPathDefinition("/paper/preview", "anon"); // 开放接口 http://localhost:8082/paper/preview
        chainDefinition.addPathDefinition("/app/getPaper", "anon"); // 开放接口 http://localhost:8082/paper/preview
        chainDefinition.addPathDefinition("/gifCode", "anon");
        chainDefinition.addPathDefinition("/logout", "logout");
        chainDefinition.addPathDefinition("/", "anon");
        chainDefinition.addPathDefinition("/**", "user");
        return chainDefinition;
    }

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 ） doit 为啥这里开启后 后会 执行两次 认证？？？
	 */
//	@Bean
//	public HashedCredentialsMatcher hashedCredentialsMatcher(){
//		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
//		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
//		return hashedCredentialsMatcher;
//	}

	/**  用于  thymeleaf 和 shiro 标签配合使用 （为了在thymeleaf里使用shiro的标签的bean）  */
    @Bean
	public ShiroDialect getShiroDialect(){
	    return new ShiroDialect();
    }

	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持; 加入注解的使用，不加入这个注解不生效
	 * @param securityManager
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

    /** cookie管理对象;记住我功能 */
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /** cookie对象; */
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：

        //setcookie()的第七个参数
        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(86400);
        return simpleCookie;
    }

    /**
     * FormAuthenticationFilter 过滤器 过滤记住我
     */
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        //对应前端的checkbox的name = rememberMe
        formAuthenticationFilter.setRememberMeParam("rememberMe");
        return formAuthenticationFilter;
    }

}