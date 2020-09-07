package com.goat.rbac.goatrbac.buzz.model;


import java.io.Serializable;

public class Student extends BaseModel implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;

	private Long studentId;

	// 学生姓名
	private String studentName;

    // 学号
	private String studentCode;

    // 手机号码
	private String studentTel;

    // 所属班级
	private String classesId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentTel() {
        return studentTel;
    }

    public void setStudentTel(String studentTel) {
        this.studentTel = studentTel;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

}
