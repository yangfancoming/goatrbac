package com.goat.rbac.goatrbac.buzz.model;


import java.io.Serializable;
import java.util.Date;


// 学生与试卷关联
public class StudentPaper implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;

	// 学生 主键id
	private Long studentId;

    // 试卷 主键id
	private Long paperId;

    // 学生答案
	private String answer;

    // 创建时间
	private Date createTime;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
