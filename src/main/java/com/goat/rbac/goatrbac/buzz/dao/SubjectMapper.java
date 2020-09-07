package com.goat.rbac.goatrbac.buzz.dao;


import com.goat.rbac.goatrbac.buzz.model.Subject;

import java.util.List;


public interface SubjectMapper {

    int insert(Subject model);

    List<Subject> find(Subject model);

    int deleteByIds(List<String> ids);
}
