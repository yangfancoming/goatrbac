package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Paper;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;

import java.util.List;
import java.util.Map;


public interface IPaperService {

    int insert(Paper model);

    List<Paper> find(Paper model);

    int deleteByIds(String ids);

    // 通过试卷主键id 查询出该试卷中的包含的所有试题id及对应试题类型
    List<PaperQuestion> preview(Long paperId);

    // 通过试题ids  查询出所有试题
    Map<String, List<Question>> getPaper(Long paperId, Long subjectId);

}
