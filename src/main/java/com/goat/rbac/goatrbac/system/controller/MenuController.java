package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.Menu;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {

	@Autowired
	private IMenuService menuService;

    @PostMapping("getUserMenu")
    public ResponseBo getUserMenu(String userName) {
        Tree<Menu> tree = menuService.getUserMenu(userName);
        return ResponseBo.ok(tree);
    }

    @RequestMapping("menuButtonTree")
    public ResponseBo getMenuButtonTree() {
        Tree<Menu> tree = menuService.getMenu(null);
        return ResponseBo.ok(tree);
    }

    @RequestMapping("tree")
    public ResponseBo getMenuTree() {
        Tree<Menu> tree = menuService.getMenu(new Menu("0"));
        return ResponseBo.ok(tree);
    }

    @RequestMapping("list")
    public List<Menu> menuList(Menu menu) {
        return menuService.findMenuList(menu);
    }

    @RequestMapping("getMenu")
    public ResponseBo getMenu(Long menuId) {
        Menu menu = menuService.findMenuList(new Menu(menuId)).get(0);
        return ResponseBo.ok(menu);
    }

    @RequestMapping("add")
    public ResponseBo addMenu(Menu menu) {
        String name;
        if (Menu.TYPE_MENU.equals(menu.getType()))
            name = "菜单";
        else
            name = "按钮";
        menu.setCreateTime(new Date());
        menuService.insert(menu);
        return ResponseBo.ok("新增" + name + "成功！");
    }

    @RequestMapping("checkMenuName")
    public boolean checkMenuName(String menuName, String type, String oldMenuName) {
        if (!StringUtils.isEmpty(oldMenuName) && menuName.equalsIgnoreCase(oldMenuName)) {
            return true;
        }
        List<Menu> menuList = menuService.findMenuList(new Menu(menuName, type));
        if (menuList.size()>0 )
            return false;
        return true;
    }

    @RequestMapping("delete")
    public ResponseBo deleteMenus(String ids) {
        List<String> split = Arrays.asList(ids.split(","));
        menuService.deleteByIds(split);
        return ResponseBo.ok("删除成功！");
    }

    @RequestMapping("update")
    public ResponseBo updateMenu(Menu menu) {
        String name;
        if (Menu.TYPE_MENU.equals(menu.getType()))
            name = "菜单";
        else
            name = "按钮";
        menuService.update(menu);
        return ResponseBo.ok("修改" + name + "成功！");
    }
}
