package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.Menu;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController extends BaseController {

	@Autowired
	private IMenuService menuService;

    @PostMapping("menu/getUserMenu")
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
            Tree<Menu> tree = menuService.getMenuButtonTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取菜单列表失败！");
        }
    }
}
