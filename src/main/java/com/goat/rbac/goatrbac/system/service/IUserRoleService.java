package com.goat.rbac.goatrbac.system.service;

import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.model.UserWithRole;

import java.util.List;

/**
 * Created by Administrator on 2020/2/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/27---17:53
 */
public interface IUserRoleService {

    Long deleteByIds(List<Long> ids);

    UserWithRole findUserWithRole(User user);

}
