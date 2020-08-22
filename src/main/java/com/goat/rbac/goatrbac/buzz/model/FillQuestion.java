package com.goat.rbac.goatrbac.buzz.model;


/**
 * Created by Administrator on 2020/8/21.
 *
 * @ Description: 填空题
 * @ author  山羊来了
 * @ date 2020/8/21---21:50
 */
public class FillQuestion extends Question {

    // 试题 答案
    private String questionAnswer;
    // 试题 选项
    private String questionOptions;

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String questionOptions) {
        this.questionOptions = questionOptions;
    }
}
