package com.goat.rbac.goatrbac.system.service;

import com.goat.rbac.goatrbac.system.model.RoleMenu;

import java.util.List;

/**
 * Created by Administrator on 2020/2/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/28---14:48
 */
public interface IRoleMenuServie {

    int delete(RoleMenu roleMenu);

    int deleteByMenuIds(List<String> menuIds);

}
