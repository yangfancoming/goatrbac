package com.goat.rbac.goatrbac.system.dao;



import com.goat.rbac.goatrbac.system.model.Menu;

import java.util.List;

public interface MenuMapper {
	
	List<Menu> findUserPermissions(String userName);
	
	List<Menu> findUserMenus(String userName);
	
	// 删除父节点，子节点变成顶级节点（根据实际业务调整）
	void changeToTop(List<String> menuIds);
}