package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.StudentMapper;
import com.goat.rbac.goatrbac.buzz.model.Student;
import com.goat.rbac.goatrbac.buzz.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2020/9/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/9/7---14:19
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public int insert(Student model) {
        return studentMapper.insert(model);
    }

    @Override
    public List<Student> find(Student model) {
        return studentMapper.find(model);
    }

    @Override
    public void deleteByIds(String ids) {
        studentMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
}
