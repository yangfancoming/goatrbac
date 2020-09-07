package com.goat.rbac.goatrbac.buzz.dao;


import com.goat.rbac.goatrbac.buzz.model.Student;

import java.util.List;


public interface StudentMapper {

    int insert(Student model);

    List<Student> find(Student model);

    int deleteByIds(List<String> ids);
}
