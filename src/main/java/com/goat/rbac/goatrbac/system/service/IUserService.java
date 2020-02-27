package com.goat.rbac.goatrbac.system.service;



import com.goat.rbac.goatrbac.system.model.User;
import java.util.List;

public interface IUserService {

	User findByName(String userName);

	User findUserOne(User user);

	List<User> findUserWithDept(User user);

	void registUser(User user);

	void updateTheme(String theme, String userName);

	void addUser(User user, Long[] roles);

	void updateUser(User user, Long[] roles);
	


	void updateLoginTime(String userName);
	
	void updatePassword(String password);
	
	User findUserProfile(User user);
	
	void updateUserProfile(User user);

    Long deleteByIds(String[] ids);
}
