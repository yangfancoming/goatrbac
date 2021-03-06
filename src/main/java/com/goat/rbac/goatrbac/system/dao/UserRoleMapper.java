package com.goat.rbac.goatrbac.system.dao;

import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.model.UserRole;
import com.goat.rbac.goatrbac.system.model.UserWithRole;

import java.util.List;

/**
 * Created by Administrator on 2020/2/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/27---16:05
 */
public interface UserRoleMapper {

    void insert(UserRole userRole);

    Long deleteById(Long userId);

    Long deleteByIds(List<Long> userId);

    Long deleteByRoleIds(List<String> roleIds);

    List<UserWithRole> findUserWithRole(User user);

    int insertList(List<UserRole> userRoleList);

}
