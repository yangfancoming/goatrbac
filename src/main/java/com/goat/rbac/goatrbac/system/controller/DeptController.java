package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.Dept;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
public class DeptController {

	@Autowired
	private IDeptService deptService;

	@RequestMapping("dept")
	public String index() {
		return "system/dept/dept";
	}

	@RequestMapping("dept/list")
	@ResponseBody
	public List<Dept> deptList(Dept dept) {
		try {
			return deptService.findDeptList(dept);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    @RequestMapping("dept/tree")
    @ResponseBody
    public ResponseBo getDeptTree() {
        try {
            Tree<Dept> tree = deptService.getDeptTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取部门列表失败！");
        }
    }

	@RequestMapping("dept/add")
	@ResponseBody
	public ResponseBo addDept(Dept dept) {
		try {
            if (dept.getParentId() == null) dept.setParentId(0l);
            dept.setCreateTime(new Date());
			deptService.insert(dept);
			return ResponseBo.ok("新增部门成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("新增部门失败，请联系网站管理员！");
		}
	}

}
