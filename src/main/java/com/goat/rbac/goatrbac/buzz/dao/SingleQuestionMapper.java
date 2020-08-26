package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.SingleQuestion;

import java.util.List;


public interface SingleQuestionMapper {

    int insert(SingleQuestion question);

    List<SingleQuestion> find(SingleQuestion question);

    int deleteByIds(List<String> ids);
}
