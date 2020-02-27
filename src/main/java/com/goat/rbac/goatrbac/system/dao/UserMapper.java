package com.goat.rbac.goatrbac.system.dao;



import com.goat.rbac.goatrbac.system.model.User;

import java.util.List;

public interface UserMapper  {

	List<User> findUserWithDept(User user);
	
//	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);

	User findUserOne(User user);

	Long insert(User user);

    Long deleteByIds(List<Long> ids);
}