package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.Paper;

import java.util.List;


public interface PaperMapper {

    int insert(Paper model);

    List<Paper> find(Paper model);

    int deleteByIds(List<String> ids);

}
