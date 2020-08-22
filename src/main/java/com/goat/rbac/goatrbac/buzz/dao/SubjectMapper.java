package com.goat.rbac.goatrbac.buzz.dao;


import com.goat.rbac.goatrbac.buzz.model.Subject;

import java.util.List;


public interface SubjectMapper {

    int insert(Subject question);

    List<Subject> find(Subject question);

    int deleteByIds(List<String> ids);
}
