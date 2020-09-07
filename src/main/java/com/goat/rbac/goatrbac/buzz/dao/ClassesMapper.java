package com.goat.rbac.goatrbac.buzz.dao;


import com.goat.rbac.goatrbac.buzz.model.Classes;

import java.util.List;


public interface ClassesMapper {

    int insert(Classes model);

    List<Classes> find(Classes model);

    int deleteByIds(List<String> ids);
}
