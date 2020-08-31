package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.common.QuestionType;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;
import com.goat.rbac.goatrbac.buzz.service.ICombineService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String index(Model model, @RequestParam Map<String ,String> params) {
        model.addAttribute("params",params);
        return "buzz/learn/combine/combine";
    }

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, @RequestParam Map<String ,String> params ) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        String questionType = params.get("questionType");
        Map<String ,String> param = new HashMap<>(2);
        param.put("tableName",QuestionType.kv.get(questionType));// 试题类型下拉框
        param.put("subjectId",params.get("subjectId")); // 所属科目下拉框
        param.put("questionType",params.get("questionType")); // 所属科目下拉框
        List<Question> result = combineService.list(param);
        PageInfo<Question> pageInfo = new PageInfo<>(result);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    @ResponseBody
    public ResponseBo add(PaperQuestion model) {
        combineService.insert(model);
        return ResponseBo.ok("添加试题成功！");
    }

    @PostMapping("delete")
    @ResponseBody
    public ResponseBo delete(PaperQuestion model) {
        combineService.delete(model);
        return ResponseBo.ok("取消试题成功！");
    }
}
