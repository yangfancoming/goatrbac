package com.goat.rbac.goatrbac.app.model;

import com.goat.rbac.goatrbac.buzz.model.BaseModel;
import com.goat.rbac.goatrbac.buzz.model.Question;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/9/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/9/9---22:17
 */
public class HandPaper extends BaseModel implements Serializable {

    private static final long serialVersionUID = -7790334862410409053L;


    // 学生手机号
    private String studentTel;

    // 所属试卷
    private Long paperId;

    // key 试题类型 questionType  value Item
    Map<Integer,List<Item>> item;


    public String getStudentTel() {
        return studentTel;
    }

    public void setStudentTel(String studentTel) {
        this.studentTel = studentTel;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Map<Integer, List<Item>> getItem() {
        return item;
    }

    public void setItem(Map<Integer, List<Item>> item) {
        this.item = item;
    }
}
