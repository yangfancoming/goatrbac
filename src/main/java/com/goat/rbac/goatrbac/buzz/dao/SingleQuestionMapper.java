package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.SingleQuestion;

import java.util.List;


public interface SingleQuestionMapper {

    int insert(SingleQuestion model);

    List<SingleQuestion> find(SingleQuestion model);

    int deleteByIds(List<String> ids);
}
