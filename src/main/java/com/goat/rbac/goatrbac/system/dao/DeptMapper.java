package com.goat.rbac.goatrbac.system.dao;




import com.goat.rbac.goatrbac.system.model.Dept;

import java.util.List;

public interface DeptMapper  {
	
	// 删除父节点，子节点变成顶级节点（根据实际业务调整）
	void changeToTop(List<String> deptIds);

    List<Dept> findDeptList(Dept dept);

    void insert(Dept dept);

    int deleteByIds(List<String> ids);
}