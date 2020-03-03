package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.Dept;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("dept")
public class DeptController {

	@Autowired
	private IDeptService deptService;

	@GetMapping("list")
    public List<Dept> deptList(Dept dept) {
        return deptService.find(dept);
    }

    @RequestMapping("tree")
    public ResponseBo getDeptTree() {
        Tree<Dept> tree = deptService.getDeptTree();
        return ResponseBo.ok(tree);
    }

	@RequestMapping("add")
	public ResponseBo add(Dept dept) {
        if (dept.getParentId() == null) dept.setParentId(0l);
        dept.setCreateTime(new Date());
        deptService.insert(dept);
        return ResponseBo.ok("新增部门成功！");
	}

    @RequestMapping("delete")
    public ResponseBo delete(String ids) {
        deptService.delete(ids);
        return ResponseBo.ok("删除部门成功！");
    }

    @RequestMapping("getDept")
    public ResponseBo getDept(Long deptId) {
        List<Dept> depts = deptService.find(new Dept(deptId));
        return ResponseBo.ok(depts.get(0));
    }

}


