package com.goat.rbac.goatrbac.buzz.model;

/**
 * Created by Administrator on 2020/8/31.
 *
 * @ Description: 试卷和题目 多对多关系
 * @ author  山羊来了
 * @ date 2020/8/31---15:45
 */
public class PaperQuestion {

    // 试卷 主键id
    private Long paperId;

    private Integer questionType;

    // 试题 主键id
    private Long questionId;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
