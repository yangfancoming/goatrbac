package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Classes;
import com.goat.rbac.goatrbac.buzz.model.Subject;

import java.util.List;


public interface IClassesService {

    int insert(Classes model);

    List<Classes> find(Classes model);

    void deleteByIds(String ids);
}
