package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.dao.UserMapper;
import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/2/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/26---15:50
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByName(String userName) {
        return null;
    }

    @Override
    public User findUserOne(User user) {
        return userMapper.findUserOne(user);
    }

    @Override
    public List<User> findUserWithDept(User user) {
        return null;
    }

    @Override
    public void registUser(User user) {

    }

    @Override
    public void updateTheme(String theme, String userName) {

    }

    @Override
    public void addUser(User user, Long[] roles) {

    }

    @Override
    public void updateUser(User user, Long[] roles) {

    }

    @Override
    public void deleteUsers(String userIds) {

    }

    @Override
    public void updateLoginTime(String userName) {

    }

    @Override
    public void updatePassword(String password) {

    }

    @Override
    public User findUserProfile(User user) {
        return userMapper.findUserProfile(user);
    }

    @Override
    public void updateUserProfile(User user) {

    }
}
