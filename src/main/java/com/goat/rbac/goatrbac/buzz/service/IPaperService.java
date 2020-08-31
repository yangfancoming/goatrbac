package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Paper;

import java.util.List;


public interface IPaperService {

    int insert(Paper question);

    List<Paper> find(Paper question);

    int deleteByIds(String ids);
}
