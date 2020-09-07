package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.ClassesMapper;
import com.goat.rbac.goatrbac.buzz.model.Classes;
import com.goat.rbac.goatrbac.buzz.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2020/3/2.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
@Service
public class ClassesServiceImpl implements IClassesService {

    @Autowired
    ClassesMapper classesMapper;

    @Override
    public int insert(Classes model) {
        return classesMapper.insert(model);
    }

    @Override
    public List<Classes> find(Classes model) {
        return classesMapper.find(model);
    }

    @Override
    public void deleteByIds(String ids) {
        classesMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
}
