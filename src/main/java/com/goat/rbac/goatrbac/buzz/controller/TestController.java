package com.goat.rbac.goatrbac.buzz.controller;

import com.goat.rbac.goatrbac.buzz.model.StudentPaper;
import com.goat.rbac.goatrbac.buzz.service.IStudentPaperService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 科目类别
@RestController
@RequestMapping("test")
public class TestController extends BaseController {

    @Autowired
    IStudentPaperService studentPaperService;

    @GetMapping("list")
    public void list() {
        List<StudentPaper> remp = studentPaperService.find(null);
        StudentPaper studentPaper = remp.get(0);
        System.out.println(studentPaper.getAnswer());
        System.out.println(studentPaper.getCreateTime());
        System.out.println(studentPaper.getPaperId());
    }


}
