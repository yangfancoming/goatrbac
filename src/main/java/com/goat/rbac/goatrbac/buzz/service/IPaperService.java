package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Paper;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;

import java.util.List;
import java.util.Map;


public interface IPaperService {

    int insert(Paper question);

    List<Paper> find(Paper question);

    int deleteByIds(String ids);

    List<PaperQuestion> preview(PaperQuestion model);
}
