package com.goat.rbac.goatrbac.buzz.model;


import java.io.Serializable;

// 试题实体类
public class Question extends BaseModel implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;

	// 主键id
	private Long questionId;

	// 所属分类id(科目)
	private Long subjectId;

    // 所属分类名称 (科目)  给前端返回使用
	private String subjectName;

//    // 试题 标签
	private Long questionLabel;

	// 试题 类型  【0单选、1多选、2填空、3简答】
    private Integer questionType;

    // 试题 类型名称  给前端返回使用
    private String questionTypeName;

    // 回显试题勾选状态  给前端返回使用
    private String state;

    // 试题 状态
    private Integer questionStatus;

    // 试题 分值
    private Integer questionScore;

    // 试题 描述
    private String questionDesc;

    // 试题 音频解答
    private String questionAudio;

    // 试题 文字解析
    private String questionText;

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

    public Integer getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(Integer questionScore) {
        this.questionScore = questionScore;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(Long questionLabel) {
        this.questionLabel = questionLabel;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


