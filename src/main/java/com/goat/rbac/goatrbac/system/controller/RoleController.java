package com.goat.rbac.goatrbac.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.system.model.*;
import com.goat.rbac.goatrbac.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;

	@PostMapping("role")
	public String index() {
		return "system/role/role";
	}

	@GetMapping("role/list")
	@ResponseBody
	public Map<String, Object> roleList(QueryRequest request, Role role) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<Role> list = roleService.findRoleList(role);
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		return getDataTable(pageInfo);
	}


}
