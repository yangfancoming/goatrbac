package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.SubjectMapper;
import com.goat.rbac.goatrbac.buzz.model.Subject;
import com.goat.rbac.goatrbac.buzz.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public int insert(Subject question) {
        int insert = subjectMapper.insert(question);
        return insert;
    }

    @Override
    public List<Subject> find(Subject question) {
        List<Subject> devices = subjectMapper.find(question);
        return devices;
    }

    @Override
    public void deleteByIds(String ids) {
        subjectMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
}
