package com.goat.rbac.goatrbac.buzz.dao;


import com.goat.rbac.goatrbac.buzz.model.Classes;

import java.util.List;


public interface ClassesMapper {

    int insert(Classes question);

    List<Classes> find(Classes question);

    int deleteByIds(List<String> ids);
}
