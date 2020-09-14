package com.goat.rbac.goatrbac.app.controller;

import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;
import com.goat.rbac.goatrbac.buzz.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/9/6.
 * @ Description: 小程序专用接口
 * @ author  山羊来了
 * @ date 2020/9/6---21:39
 */
@RestController
@RequestMapping("app")
public class AppController {

    @Autowired
    IPaperService paperService;

    // http://localhost:8080/app/getPaper?paperId=3
    // http://goatcoming.cn/app/getPaper?paperId=3
    @GetMapping("getPaper")
    public List<Question> getPaper(PaperQuestion paperQuestion) {
        Map<String, List<Question>> paper = paperService.getPaper(paperQuestion.getPaperId(), paperQuestion.getSubjectId());
        List<Question> list = new ArrayList<>(32);
        paper.keySet().forEach(k ->list.addAll(paper.get(k)));
        return list;
    }
}
