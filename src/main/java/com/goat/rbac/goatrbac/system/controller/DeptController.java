package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.Dept;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class DeptController {

	@Autowired
	private IDeptService deptService;

	@RequestMapping("dept/list")
	public List<Dept> deptList(Dept dept) {
		try {
			return deptService.find(dept);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    @RequestMapping("dept/tree")
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

    @RequestMapping("dept/delete")
    public ResponseBo delete(String ids) {
        try {
            deptService.delete(ids);
            return ResponseBo.ok("删除部门成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除部门失败，请联系网站管理员！");
        }
    }

    @RequestMapping("dept/getDept")
    public ResponseBo getDept(Long deptId) {
        try {
            List<Dept> depts = deptService.find(new Dept(deptId));
            return ResponseBo.ok(depts.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取部门信息失败，请联系网站管理员！");
        }
    }

}


