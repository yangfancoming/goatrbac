package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.dao.RoleMapper;
import com.goat.rbac.goatrbac.system.dao.RoleMenuMapper;
import com.goat.rbac.goatrbac.system.dao.UserRoleMapper;
import com.goat.rbac.goatrbac.system.model.Role;
import com.goat.rbac.goatrbac.system.model.RoleMenu;
import com.goat.rbac.goatrbac.system.model.RoleWithMenu;
import com.goat.rbac.goatrbac.system.model.UserRole;
import com.goat.rbac.goatrbac.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/2/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/26---15:51
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> findUserRole(String userName) {
        return roleMapper.findUserRole(userName);
    }

    @Override
    public List<Role> findRoleList(Role role) {
        return roleMapper.findRoleList(role);
    }

    @Override
    public Role findByName(String roleName) {
        return null;
    }

    @Override
    public void addRole(Role role, Long[] menuIds) {
        role.setCreateTime(new Date());
        roleMapper.insert(role);
        List<RoleMenu> roleMenuList = new ArrayList<>(16);
        Arrays.asList(menuIds).forEach(x->roleMenuList.add(new RoleMenu(role.getRoleId(),x)));
        int i = roleMenuMapper.insertList(roleMenuList);
        System.out.println(i);
    }

    /**
     userMapper.update(user);
     // 删除该用户下所有角色信息
     userRoleMapper.deleteById(user.getUserId());
     // 重新插入该用户的所有角色信息
     List<UserRole> userRoleList = new ArrayList<>(16);
     Arrays.asList(roles).forEach(x->userRoleList.add(new UserRole(user.getUserId(),x)));
     int i = userRoleMapper.insertList(userRoleList);
     System.out.println(i);
    */
    @Override
    public void updateRole(Role role, Long[] menuIds) {
        // 更新角色
        roleMapper.update(role);
        // 删除该角色下所有菜单信息
        int delete = roleMenuMapper.delete(new RoleMenu(role.getRoleId()));
        // 重新插入该角色的所有菜单信息
        List<RoleMenu> roleMenuList = new ArrayList<>(16);
        Arrays.asList(menuIds).forEach(menuId->roleMenuList.add(new RoleMenu(role.getRoleId(),menuId)));
        int i = roleMenuMapper.insertList(roleMenuList);
        System.out.println(i);
    }

    @Override
    @Transactional
    public void deleteRoles(String roleIds) {
        String[] split = roleIds.split(",");
        List<String> list = Arrays.asList(split);
        roleMapper.deleteByIds(list);
        roleMenuMapper.deleteByRoleIds(list);
        Long aLong = userRoleMapper.deleteByRoleIds(list);
        System.out.println(aLong);
    }

    @Override
    public RoleWithMenu findRoleWithMenus(Long roleId) {
        List<RoleWithMenu> list = roleMenuMapper.findRoleWithMenus(roleId);
        if (list.size() == 0) return null;
        List<Long> menuList = new ArrayList<>();
        list.forEach(rwm->menuList.add(rwm.getMenuId()));
        RoleWithMenu roleWithMenu = list.get(0);
        roleWithMenu.setMenuIds(menuList);
        return roleWithMenu;
    }

    @Override
    public int insert(Role role) {
        int insert = roleMapper.insert(role);
        return insert;
    }

    @Override
    public int deleteById(Long roleId) {
        return roleMapper.deleteById(roleId);
    }

    @Override
    public int deleteByIds(List<String> roleIds) {
        int i = roleMapper.deleteByIds(roleIds);
        return i;
    }

    @Override
    public Long deleteByRoleIds(List<String> roleIds) {
        return null;
    }
}
