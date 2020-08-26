package com.goat.rbac.goatrbac.buzz.model;


import java.io.Serializable;


// 试卷实体类
public class Paper extends BaseModel implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;

	// 主键id
	private Long paperId;

    // 试卷 名称
    private String paperName;

	// 试卷 分类  （科目）
    private Long subjectId;

    // 试卷 状态
    private Integer paperStatus;

    // 试卷 分值
    private Integer paperScore;

    // 试卷 描述
    private String paperDesc;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(Integer paperStatus) {
        this.paperStatus = paperStatus;
    }


    public Integer getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }

    public String getPaperDesc() {
        return paperDesc;
    }

    public void setPaperDesc(String paperDesc) {
        this.paperDesc = paperDesc;
    }

}


