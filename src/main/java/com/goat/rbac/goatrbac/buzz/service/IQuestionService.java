package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Question;

import java.util.List;


public interface IQuestionService {

    int insert(Question model);

    List<Question> find(Question model);

    void deleteByIds(String ids);
}
