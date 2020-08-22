package com.goat.rbac.goatrbac.buzz.model;


import java.io.Serializable;
import java.util.Date;

// 试题实体类
public class Question implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;

	// 主键id
	private Long questionId;

//	// 所属分类(科目)
//	private Long subjectId;
//
//    // 试题 标签
//	private Long questionLabel;

	// 试题 类型  【0单选、1多选、2填空、3简答】
    private Integer questionType;

    // 试题 状态
    private Integer questionStatus;

    // 试题 分值
    private Integer questioScore;

    // 试题 描述
    private String questionDesc;

    // 试题 音频解答
    private String questionAudio;

    // 试题 文字解析
    private String questionText;

    private Date modifyTime;

    private Date createTime;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(Integer questionStatus) {
        this.questionStatus = questionStatus;
    }

    public String getQuestionAudio() {
        return questionAudio;
    }

    public void setQuestionAudio(String questionAudio) {
        this.questionAudio = questionAudio;
    }

    public Integer getQuestioScore() {
        return questioScore;
    }

    public void setQuestioScore(Integer questioScore) {
        this.questioScore = questioScore;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

}


