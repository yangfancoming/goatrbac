package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.Paper;

import java.util.List;


public interface PaperMapper {

    int insert(Paper question);

    List<Paper> find(Paper question);

    int deleteByIds(List<String> ids);

}
