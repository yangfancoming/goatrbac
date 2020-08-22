package com.goat.rbac.goatrbac.buzz.model;


import java.io.Serializable;
import java.util.Date;


// 试卷实体类
public class Paper implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;

	// 主键id
	private Long paperId;

    // 试卷 名称
    private String paperName;

	// 试题 类型  【0单选、1多选、2填空、3简答】
    private Integer paperType;

    // 试题 状态
    private Integer paperStatus;

    // 试题 分值
    private Integer questioScore;

    // 试题 答案
    private String paperAnswer;

    // 试题 描述
    private String paperDesc;

    // 试题 选项
    private String paperOptions;

    // 试题 音频解答
    private String paperAudio;

    // 试题 文字解析


    private Date modifyTime;

    private Date createTime;

}


