package com.goat.rbac.goatrbac.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.Role;
import com.goat.rbac.goatrbac.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;

	@RequestMapping("list")
	public Map<String, Object> roleList(QueryRequest request, Role role) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<Role> list = roleService.findRoleList(role);
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		return getDataTable(pageInfo);
	}

    @RequestMapping("getRole")
    public ResponseBo getRole(Long roleId) {
        Role role = roleService.findRoleWithMenus(roleId);
        return ResponseBo.ok(role);
    }

    @RequestMapping("add")
    public ResponseBo add(Role role, Long[] menuId) {
        roleService.addRole(role, menuId);
        return ResponseBo.ok("新增角色成功！");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseBo delete(String ids) {
        this.roleService.deleteRoles(ids);
        return ResponseBo.ok("删除角色成功！");
    }

    @RequestMapping("update")
    public ResponseBo update(Role role, Long[] menuId) {
        roleService.updateRole(role, menuId);
        return ResponseBo.ok("修改角色成功！");
    }

}
