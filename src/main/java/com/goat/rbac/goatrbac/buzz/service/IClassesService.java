package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Classes;
import com.goat.rbac.goatrbac.buzz.model.Subject;

import java.util.List;


public interface IClassesService {

    int insert(Classes question);

    List<Classes> find(Classes question);

    void deleteByIds(String ids);
}
