package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.model.FillQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;
import com.goat.rbac.goatrbac.buzz.service.IFillQuestionService;
import com.goat.rbac.goatrbac.buzz.service.IQuestionService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

// 题库管理--- 填空题
@RestController
@RequestMapping("fillquestion")
public class FillQuestionController extends BaseController {

    @Autowired
    IFillQuestionService fillQuestionService;

    @GetMapping("list")
    public Map<String, Object> list(QueryRequest request, FillQuestion question) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<FillQuestion> devices = fillQuestionService.find(question);
        PageInfo<FillQuestion> pageInfo = new PageInfo<>(devices);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    public ResponseBo add(FillQuestion question) {
        question.setCreateTime(new Date());
        int insert = fillQuestionService.insert(question);
        return ResponseBo.ok("新增试题成功！"+insert);
    }

    @RequestMapping("delete")
    public ResponseBo delete(String ids) {
        fillQuestionService.deleteByIds(ids);
        return ResponseBo.ok("删除试题成功！");
    }

}
