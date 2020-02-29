package com.goat.rbac.goatrbac.system.service.impl;


import com.goat.rbac.goatrbac.system.dao.DeptMapper;
import com.goat.rbac.goatrbac.system.model.Dept;
import com.goat.rbac.goatrbac.system.model.Tree;
import com.goat.rbac.goatrbac.system.service.IDeptService;
import com.goat.rbac.goatrbac.system.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DeptServiceImpl  implements IDeptService {

	@Autowired
	private DeptMapper deptMapper;

    @Override
    public Tree<Dept> getDeptTree() {
        List<Tree<Dept>> trees = new ArrayList<>();
        List<Dept> depts = deptMapper.find(null);
        depts.forEach(dept->trees.add(new Tree<>(dept.getDeptId().toString(), dept.getDeptName(), dept.getParentId().toString())));
        Tree<Dept> t = TreeUtils.build(trees);
        return t;
    }

    @Override
    public List<Dept> find(Dept dept) {
        return deptMapper.find(dept);
    }


    @Override
    public void insert(Dept dept) {
        Long parentId = dept.getParentId();
        if (parentId == null) dept.setParentId(0l);
        dept.setCreateTime(new Date());
        deptMapper.insert(dept);
    }


    @Override
    public void updateDept(Dept dept) {

    }

    @Override
    public void delete(String deptIds) {
        int i = deptMapper.deleteByIds(Arrays.asList(deptIds.split(",")));
        System.out.println(i);
    }
}
