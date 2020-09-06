package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Paper;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;

import java.util.List;


public interface IPaperService {

    int insert(Paper question);

    List<Paper> find(Paper question);

    int deleteByIds(String ids);

    // 通过试卷主键id 查询出该试卷中的包含的所有试题
    List<PaperQuestion> preview(Long paperId);
}
