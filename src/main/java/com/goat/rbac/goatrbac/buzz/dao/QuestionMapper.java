package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.Question;

import java.util.List;


public interface QuestionMapper {

    int insert(Question model);

    List<Question> find(Question model);

    int deleteByIds(List<String> ids);
}
