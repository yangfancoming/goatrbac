package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.model.Menu;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IMenuService;
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
public class MenuServiceImpl implements IMenuService {

    @Override
    public List<Menu> findUserPermissions(String userName) {
        return null;
    }

    @Override
    public List<Menu> findUserMenus(String userName) {
        return null;
    }

    @Override
    public List<Menu> findAllMenus(Menu menu) {
        return null;
    }

    @Override
    public Tree<Menu> getMenuButtonTree() {
        return null;
    }

    @Override
    public Tree<Menu> getMenuTree() {
        return null;
    }

    @Override
    public Tree<Menu> getUserMenu(String userName) {
        return null;
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
