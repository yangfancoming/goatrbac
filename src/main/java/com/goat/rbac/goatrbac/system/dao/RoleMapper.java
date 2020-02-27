package com.goat.rbac.goatrbac.system.dao;



import com.goat.rbac.goatrbac.system.model.Role;

import java.util.List;

public interface RoleMapper  {
	
	List<Role> findUserRole(String userName);

	List<Role> findRoleList(Role role);


}