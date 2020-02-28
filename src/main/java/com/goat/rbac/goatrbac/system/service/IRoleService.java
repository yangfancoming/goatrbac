package com.goat.rbac.goatrbac.system.service;



import com.goat.rbac.goatrbac.system.model.Role;
import com.goat.rbac.goatrbac.system.model.RoleWithMenu;

import java.util.List;

public interface IRoleService {

	List<Role> findUserRole(String userName);

	List<Role> findRoleList(Role role);


	Role findByName(String roleName);

	void addRole(Role role, Long[] menuIds);
	
	void updateRole(Role role, Long[] menuIds);

	void deleteRoles(String roleIds);

    RoleWithMenu findRoleWithMenus(Long roleId);

}
