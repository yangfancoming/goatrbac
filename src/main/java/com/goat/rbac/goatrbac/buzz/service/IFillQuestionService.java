package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.FillQuestion;

import java.util.List;


public interface IFillQuestionService {

    int insert(FillQuestion question);

    List<FillQuestion> find(FillQuestion question);

    void deleteByIds(String ids);
}
