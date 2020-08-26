package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.SingleQuestion;

import java.util.List;


public interface ISingleQuestionService {

    int insert(SingleQuestion question);

    List<SingleQuestion> find(SingleQuestion question);

    void deleteByIds(String ids);
}
