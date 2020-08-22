package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Subject;

import java.util.List;


public interface ISubjectService {

    int insert(Subject question);

    List<Subject> find(Subject question);

    void deleteByIds(String ids);
}
