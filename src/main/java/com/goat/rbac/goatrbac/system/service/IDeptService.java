package com.goat.rbac.goatrbac.system.service;


import com.goat.rbac.goatrbac.system.model.Dept;
import com.goat.rbac.goatrbac.system.model.Tree;

import java.util.List;

public interface IDeptService {

	Tree<Dept> getDeptTree();

	List<Dept> findDeptList(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void insert(Dept dept);
	
	void updateDept(Dept dept);

	void delete(String deptIds);
}
