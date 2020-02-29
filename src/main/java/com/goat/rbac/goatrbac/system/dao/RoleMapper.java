package com.goat.rbac.goatrbac.system.dao;



import com.goat.rbac.goatrbac.system.model.Role;

import java.util.List;

public interface RoleMapper  {
	
	List<Role> findUserRole(String userName);

	List<Role> findRoleList(Role role);

	int insert(Role role);

    int update(Role role);

	int deleteById(Long roleId);

	int deleteByIds(List<String> roleIds);


}