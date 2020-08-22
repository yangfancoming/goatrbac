package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.FillQuestion;

import java.util.List;


public interface FillQuestionMapper {

    int insert(FillQuestion question);

    List<FillQuestion> find(FillQuestion question);

    int deleteByIds(List<String> ids);
}
