package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;

import java.util.List;


public interface PaperQuestionMapper {

    List<PaperQuestion> preview(Long paperId);
}
