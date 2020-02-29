package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.dao.UserRoleMapper;
import com.goat.rbac.goatrbac.system.model.User;
import com.goat.rbac.goatrbac.system.model.UserRole;
import com.goat.rbac.goatrbac.system.model.UserWithRole;
import com.goat.rbac.goatrbac.system.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/2/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/27---17:54
 */
@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Long deleteByIds(List<Long> ids) {
        Long aLong = userRoleMapper.deleteByIds(ids);
        return aLong;
    }

    /** list 的值
     * 6	tester	6	tester@qq.com	13888888888	1	1	1
     * 6	tester	6	tester@qq.com	13888888888	1	1	2
     * 6	tester	6	tester@qq.com	13888888888	1	1	3
     * 6	tester	6	tester@qq.com	13888888888	1	1	25
     * 6	tester	6	tester@qq.com	13888888888	1	1	63
     *  这样做只是为了一次打库 就能查出用户和该用户所有的角色id
    */
    @Override
    public UserWithRole findUserWithRole(User user) {
        // 获取同一用户 不同角色id的集合
        List<UserWithRole> list = userRoleMapper.findUserWithRole(user);
        if (list.size() == 0) return null;
        // 填充 roleIds
        List<Long> roleIds = new ArrayList<>();
        list.forEach(uwr->roleIds.add(uwr.getRoleId()));
        // 填充用户对象 (相同用户集合中随便拿出一个)
        UserWithRole userWithRole = list.get(0);
        userWithRole.setRoleIds(roleIds);
        return userWithRole;
    }


}
