package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.model.Paper;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.service.IPaperService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

// 试卷管理
@Controller
@RequestMapping("paper")
public class PaperController extends BaseController {

    @Autowired
    IPaperService paperService;

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Paper model) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Paper> devices = paperService.find(model);
        PageInfo<Paper> pageInfo = new PageInfo<>(devices);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    @ResponseBody
    public ResponseBo add(Paper model) {
        model.setCreateTime(new Date());
        paperService.insert(model);
        return ResponseBo.ok("新增试题成功！");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseBo delete(String ids) {
        paperService.deleteByIds(ids);
        return ResponseBo.ok("删除试题成功！");
    }

    @GetMapping("preview")
    public String preview(Model model,PaperQuestion paperQuestion) {
        List<PaperQuestion> paperQuestions = paperService.preview(paperQuestion);
        // 分组后 key为 questionType value为当前试题类型下的题目
        Map<Integer, List<Long>> map = paperQuestions.stream().collect(groupingBy(x->x.getQuestionType(), mapping(x->x.getQuestionId(), toList())));
//        map.forEach((k, v) -> {
//            String tableName = QuestionType.kv.get(k); // 通过map的key获取对应的表名
//        });

        model.addAttribute("userList", paperQuestions);
        return "buzz/learn/paper/previewPaper";
    }

}
