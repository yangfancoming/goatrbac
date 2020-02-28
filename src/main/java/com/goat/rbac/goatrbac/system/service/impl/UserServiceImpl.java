package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.dao.UserMapper;
import com.goat.rbac.goatrbac.system.dao.UserRoleMapper;
import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.model.UserRole;
import com.goat.rbac.goatrbac.system.model.UserWithRole;
import com.goat.rbac.goatrbac.system.service.IUserService;
import com.goat.rbac.goatrbac.system.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;


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
        try {
            List<User> users = userMapper.findUserWithDept(user);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void registUser(User user) {

    }

    @Override
    public void updateTheme(String theme, String userName) {

    }

    @Override
    public void addUser(User user, Long[] roles) {
        user.setCreateTime(new Date());
        user.setTheme(User.DEFAULT_THEME);
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        Long userId = userMapper.insert(user);
        for (Long roleId : roles) {
            userRoleMapper.insert(new UserRole(user.getUserId(),roleId));
        }
    }

    @Override
    public void updateUser(User user, Long[] roles) {

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

    @Override
    @Transactional
    public Long deleteByIds(String[] ids) {
        Long aLong = userMapper.deleteByIds(ids);
        List<Long> temp = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            temp.add(Long.valueOf(ids[i]));
        }
//        int i = 2/0;
        Long aLong1 = userRoleMapper.deleteByIds(temp);
        return aLong1;
    }
}
