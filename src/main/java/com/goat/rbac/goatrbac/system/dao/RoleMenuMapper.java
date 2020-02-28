package com.goat.rbac.goatrbac.system.dao;

import com.goat.rbac.goatrbac.system.model.RoleMenu;
import com.goat.rbac.goatrbac.system.model.RoleWithMenu;

import java.util.List;

/**
 * Created by Administrator on 2020/2/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/28---14:48
 */
public interface RoleMenuMapper {

    int delete(RoleMenu roleMenu);

    int deleteByRoleIds(List<String> roleIds);

    int deleteByMenuIds(List<String> menuIds);

    List<RoleWithMenu> findRoleWithMenus(Long roleId);

}
