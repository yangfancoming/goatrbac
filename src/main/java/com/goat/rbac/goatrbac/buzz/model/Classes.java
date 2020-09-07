package com.goat.rbac.goatrbac.buzz.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/9/7.
 *
 * @ Description: 年级班级
 * @ author  山羊来了
 * @ date 2020/9/7---13:26
 */
public class Classes extends BaseModel implements Serializable {

    private static final long serialVersionUID = -7790334862410409053L;

    private Long classesId;

    private String classesName;


    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }
}
