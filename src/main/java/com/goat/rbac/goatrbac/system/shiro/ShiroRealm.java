package com.goat.rbac.goatrbac.system.shiro;

import com.goat.rbac.goatrbac.system.model.Menu;
import com.goat.rbac.goatrbac.system.model.Role;
import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.service.IMenuService;
import com.goat.rbac.goatrbac.system.service.IRoleService;
import com.goat.rbac.goatrbac.system.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class ShiroRealm extends AuthorizingRealm {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;

    /* 执行认证 ： 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("进入 认证 ");
        //获取用户的输入的账号、密码
        String userName = (String) token.getPrincipal();
        // 1. 判断账号
        User user = this.userService.findUserOne(new User(userName));
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        String password = new String((char[]) token.getCredentials());
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if ("0".equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        /**
         *  P1 = 数据库账号  P2 = 数据库密码  P3 =  定死的
         *  这些需要注意的是   如果 SecurityManager 管理器函数中  securityManager.setRealm(myShiroRealm)
         *  设置的自定义realm  又设置了 hashedCredentialsMatcher 的 MD5 那么 P2 必须是 经过 M5 加密的
         *  如果加密了不知道加密的密码   就去掉 盐值 再将表中的密码改成明文的
         * */
        // 2. 判断密码
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

    /* 执行授权 ：*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        log.info("进入 授权 ");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUsername();

        SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();

        // 授权角色信息
        List<Role> roleList = roleService.findUserRole(userName);
        Set<String> roleSet = new HashSet<>();
        for (Role r : roleList) {
            roleSet.add(r.getRoleName());
        }
        authInfo.setRoles(roleSet);

        //授权菜单信息
        List<Menu> permissionList = menuService.findUserPermissions(userName);
        Set<String> permissionSet = new HashSet<>();
        for (Menu m : permissionList) {
            permissionSet.add(m.getPerms());
        }
        authInfo.setStringPermissions(permissionSet);
        return authInfo;
    }


}