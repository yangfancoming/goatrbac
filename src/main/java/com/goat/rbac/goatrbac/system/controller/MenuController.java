package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.Menu;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
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
            return menuService.findMenuList(menu);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("menu/getMenu")
    @ResponseBody
    public ResponseBo getMenu(Long menuId) {
        try {
            Menu menu = menuService.findMenuList(new Menu(menuId)).get(0);
            return ResponseBo.ok(menu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("menu/add")
    @ResponseBody
    public ResponseBo addMenu(Menu menu) {
        String name;
        if (Menu.TYPE_MENU.equals(menu.getType()))
            name = "菜单";
        else
            name = "按钮";
        try {
            menu.setCreateTime(new Date());
            menuService.insert(menu);
            return ResponseBo.ok("新增" + name + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增" + name + "失败，请联系网站管理员！");
        }
    }

    @RequestMapping("menu/checkMenuName")
    @ResponseBody
    public boolean checkMenuName(String menuName, String type, String oldMenuName) {
        if (!StringUtils.isEmpty(oldMenuName) && menuName.equalsIgnoreCase(oldMenuName)) {
            return true;
        }
        List<Menu> menuList = menuService.findMenuList(new Menu(menuName, type));
        if (menuList.size()>0 )
            return false;
        return true;
    }

    @RequestMapping("menu/delete")
    @ResponseBody
    public ResponseBo deleteMenus(String ids) {
        try {
            List<String> split = Arrays.asList(ids.split(","));
            menuService.deleteByIds(split);
            return ResponseBo.ok("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除失败，请联系网站管理员！");
        }
    }
}
