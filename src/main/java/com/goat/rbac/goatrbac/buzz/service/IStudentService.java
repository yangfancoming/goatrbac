package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Student;

import java.util.List;


public interface IStudentService {

    int insert(Student model);

    List<Student> find(Student model);

    void deleteByIds(String ids);
}
