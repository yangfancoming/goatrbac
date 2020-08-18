package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.Question;

import java.util.List;


public interface QuestionMapper {

    int insert(Question device);

    List<Question> find(Question dept);
}
