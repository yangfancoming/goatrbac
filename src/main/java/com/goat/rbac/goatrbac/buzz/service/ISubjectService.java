package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Subject;

import java.util.List;


public interface ISubjectService {

    int insert(Subject model);

    List<Subject> find(Subject model);

    void deleteByIds(String ids);
}
