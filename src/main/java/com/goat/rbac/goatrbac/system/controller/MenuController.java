package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.Menu;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MenuController extends BaseController {

	@Autowired
	private IMenuService menuService;

    @PostMapping("menu/getUserMenu")
    @ResponseBody
    public ResponseBo getUserMenu(String userName) {
        try {
            Tree<Menu> tree = menuService.getUserMenu(userName);
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取用户菜单失败！");
        }
    }

    @RequestMapping("menu/menuButtonTree")
    @ResponseBody
    public ResponseBo getMenuButtonTree() {
        try {
            Tree<Menu> tree = menuService.getMenu(null);
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取菜单列表失败！");
        }
    }

    @RequestMapping("menu")
    @RequiresPermissions("menu:list")
    public String index() {
        return "system/menu/menu";
    }

    @RequestMapping("menu/tree")
    @ResponseBody
    public ResponseBo getMenuTree() {
        try {
            Tree<Menu> tree = menuService.getMenu(new Menu("0"));
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取菜单列表失败！");
        }
    }

    @RequestMapping("menu/list")
    @ResponseBody
    public List<Menu> menuList(Menu menu) {
        try {
            return this.menuService.findAllMenus(menu);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
