package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.FillQuestion;

import java.util.List;


public interface IFillQuestionService {

    int insert(FillQuestion model);

    List<FillQuestion> find(FillQuestion model);

    void deleteByIds(String ids);
}
