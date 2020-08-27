package com.goat.rbac.goatrbac.buzz.model;


/**
 * Created by Administrator on 2020/8/21.
 *
 * @ Description: 填空题
 * @ author  山羊来了
 * @ date 2020/8/21---21:50
 */
public class SingleQuestion extends Question {

    // 试题 选项
    private String questionOptions;

    // 试题 选项格式化
    private String questionFormat;

    // 试题 答案
    private String questionAnswer;

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

    public String getQuestionFormat() {
        return questionFormat;
    }

    public void setQuestionFormat(String questionFormat) {
        this.questionFormat = questionFormat;
    }
}
