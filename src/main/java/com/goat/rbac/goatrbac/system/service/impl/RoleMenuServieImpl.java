package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.dao.RoleMenuMapper;
import com.goat.rbac.goatrbac.system.model.RoleMenu;
import com.goat.rbac.goatrbac.system.service.IRoleMenuServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/2/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/28---15:02
 */
@Service
public class RoleMenuServieImpl implements IRoleMenuServie {

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public int delete(RoleMenu roleMenu) {
        int delete = roleMenuMapper.delete(roleMenu);
        return delete;
    }

    @Override
    public int deleteByRoleIds(List<String> roleIds) {
        int i = roleMenuMapper.deleteByRoleIds(roleIds);
        return i;
    }

    @Override
    public int deleteByMenuIds(List<String> menuIds) {
        int i = roleMenuMapper.deleteByMenuIds(menuIds);
        return i;
    }

    @Override
    public int insertList(List<RoleMenu> roleMenuList) {
        int i = roleMenuMapper.insertList(roleMenuList);
        return i;
    }
}
