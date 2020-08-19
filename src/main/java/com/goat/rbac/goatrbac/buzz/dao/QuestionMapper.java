package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.Question;

import java.util.List;


public interface QuestionMapper {

    int insert(Question question);

    List<Question> find(Question question);

    int deleteByIds(List<String> ids);
}
