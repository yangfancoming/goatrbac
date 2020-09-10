package com.goat.rbac.goatrbac.app.model;

import com.goat.rbac.goatrbac.buzz.model.BaseModel;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/9/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/9/9---22:25
 */
public class Item extends BaseModel implements Serializable {

    private static final long serialVersionUID = -7790334862410409053L;

    // 试题编号
    private Long questionId;


    private String answer;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
