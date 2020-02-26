package com.goat.rbac.goatrbac.system.service;



import com.goat.rbac.goatrbac.system.model.Role;

import java.util.List;

public interface IRoleService {

	List<Role> findUserRole(String userName);

	List<Role> findAllRole(Role role);
	

	Role findByName(String roleName);

	void addRole(Role role, Long[] menuIds);
	
	void updateRole(Role role, Long[] menuIds);

	void deleteRoles(String roleIds);
}