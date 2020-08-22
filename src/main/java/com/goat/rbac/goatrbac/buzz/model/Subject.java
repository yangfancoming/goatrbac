package com.goat.rbac.goatrbac.buzz.model;

/**
 * Created by Administrator on 2020/8/22.
 *
 * @ Description: 科目类别
 * @ author  山羊来了
 * @ date 2020/8/22---21:26
 */
public class Subject extends BaseModel {

    private Long subjectId;

    private String subjectName;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
