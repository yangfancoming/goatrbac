package com.goat.rbac.goatrbac.app.controller;

import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;
import com.goat.rbac.goatrbac.buzz.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("getPaper")
    public Map<String, List<Question>> getPaper(PaperQuestion paperQuestion) {
        return paperService.getPaper(paperQuestion.getPaperId(), paperQuestion.getSubjectId());
    }
}
