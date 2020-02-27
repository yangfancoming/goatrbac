package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.dao.MenuMapper;
import com.goat.rbac.goatrbac.system.model.Menu;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IMenuService;
import com.goat.rbac.goatrbac.system.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/2/26.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/26---15:51
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findUserPermissions(String userName) {
        return menuMapper.findUserPermissions(userName);
    }

    @Override
    public List<Menu> findUserMenus(String userName) {
        return menuMapper.findUserMenus(userName);
    }

    @Override
    public List<Menu> findAllMenus(Menu menu) {
        return null;
    }

    @Override
    public Tree<Menu> getMenuButtonTree() {
        List<Tree<Menu>> trees = new ArrayList<>();
        List<Menu> menus = menuMapper.findMenuList(new Menu());
        menus.forEach(menu->trees.add(new Tree<>(menu.getMenuId().toString(), menu.getMenuName(), menu.getParentId().toString())));
        return TreeUtils.build(trees);
    }

    @Override
    public Tree<Menu> getMenuTree() {
        return null;
    }

    @Override
    public Tree<Menu> getUserMenu(String userName) {
        List<Tree<Menu>> trees = new ArrayList<>();
        List<Menu> menus = findUserMenus(userName);
        menus.forEach(menu->trees.add(new Tree<>(menu.getMenuId().toString(), menu.getIcon(), menu.getUrl(), menu.getMenuName(),menu.getParentId().toString())));
        Tree<Menu> t = TreeUtils.build(trees);
        return t;
    }

    @Override
    public Menu findById(Long menuId) {
        return null;
    }

    @Override
    public Menu findByNameAndType(String menuName, String type) {
        return null;
    }

    @Override
    public void addMenu(Menu menu) {

    }

    @Override
    public void updateMenu(Menu menu) {

    }

    @Override
    public void deleteMeuns(String menuIds) {

    }
}
