package com.goat.rbac.goatrbac.system.service.impl;

import com.goat.rbac.goatrbac.system.dao.UserRoleMapper;
import com.goat.rbac.goatrbac.system.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
