package com.goat.rbac.goatrbac.system.service;


import com.goat.rbac.goatrbac.system.model.Menu;
import com.goat.rbac.goatrbac.system.model.Tree;

import java.util.List;

public interface IMenuService {

	List<Menu> findUserPermissions(String userName);

	List<Menu> findUserMenus(String userName);

	List<Menu> findMenuList(Menu menu);

	Tree<Menu> getMenu(Menu menu);

	Tree<Menu> getUserMenu(String userName);
	
	Menu findById(Long menuId);

	Menu findByNameAndType(String menuName, String type);

	void insert(Menu menu);

	void updateMenu(Menu menu);
	
	void deleteMeuns(String menuIds);

    int deleteByIds(List<String> menuIds);
}
