package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Question;

import java.util.List;


public interface IQuestionService {

    int insert(Question question);

    List<Question> find(Question question);

    void deleteByIds(String ids);
}
