package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.model.SingleQuestion;
import com.goat.rbac.goatrbac.buzz.service.ISingleQuestionService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

// 题库管理--- 填空题
@RestController
@RequestMapping("singlequestion")
public class SingleQuestionController extends BaseController {

    @Autowired
    ISingleQuestionService singleQuestionService;

    @GetMapping("list")
    public Map<String, Object> list(QueryRequest request, SingleQuestion question) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<SingleQuestion> devices = singleQuestionService.find(question);
        PageInfo<SingleQuestion> pageInfo = new PageInfo<>(devices);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    public ResponseBo add(SingleQuestion question) {
        singleQuestionService.insert(question);
        return ResponseBo.ok("新增试题成功！");
    }

    @RequestMapping("delete")
    public ResponseBo delete(String ids) {
        singleQuestionService.deleteByIds(ids);
        return ResponseBo.ok("删除试题成功！");
    }
}
