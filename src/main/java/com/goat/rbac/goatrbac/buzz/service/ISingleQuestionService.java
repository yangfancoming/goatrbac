package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.SingleQuestion;

import java.util.List;


public interface ISingleQuestionService {

    int insert(SingleQuestion model);

    List<SingleQuestion> find(SingleQuestion model);

    void deleteByIds(String ids);
}
