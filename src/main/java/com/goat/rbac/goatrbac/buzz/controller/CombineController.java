package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.common.QuestionType;
import com.goat.rbac.goatrbac.buzz.service.ICombineService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 组卷管理
@Controller
@RequestMapping("combine")
public class CombineController extends BaseController {

    @Autowired
    ICombineService combineService;

    @GetMapping("/jump")
    public String index() {
        return "buzz/learn/combine/combine";
    }

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, @RequestParam Map<String ,String> params ) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        String tableName = QuestionType.kv.get(params.get("questionType")); // 试题类型下拉框
        Map<String ,String> param = new HashMap<>(2);
        param.put("tableName",tableName);
        param.put("subjectId",params.get("subjectId")); // 所属科目下拉框
        List<Map> devices = combineService.list(param);
        PageInfo<Map> pageInfo = new PageInfo<>(devices);
        return getDataTable(pageInfo);
    }

}
