package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.model.Role;
import com.goat.rbac.goatrbac.system.service.IRoleService;
import org.springframework.stereotype.Service;

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


    @Override
    public List<Role> findUserRole(String userName) {
        return null;
    }

    @Override
    public List<Role> findAllRole(Role role) {
        return null;
    }

    @Override
    public Role findByName(String roleName) {
        return null;
    }

    @Override
    public void addRole(Role role, Long[] menuIds) {

    }

    @Override
    public void updateRole(Role role, Long[] menuIds) {

    }

    @Override
    public void deleteRoles(String roleIds) {

    }
}