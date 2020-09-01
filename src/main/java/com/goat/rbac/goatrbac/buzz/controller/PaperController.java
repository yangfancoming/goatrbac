package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.common.QuestionType;
import com.goat.rbac.goatrbac.buzz.model.Paper;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;
import com.goat.rbac.goatrbac.buzz.service.ICombineService;
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

import java.util.*;

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

    @Autowired
    ICombineService combineService;

    @GetMapping("preview")
    public String preview(Model model,PaperQuestion paperQuestion) {
        List<PaperQuestion> paperQuestions = paperService.preview(paperQuestion);
        // 分组后 key为 questionType value为当前试题类型下的题目 questionId
        Map<Integer, List<Long>> map = paperQuestions.stream().collect(groupingBy(x->x.getQuestionType(), mapping(x->x.getQuestionId(), toList())));
        //
        Map<String, List<Question>> resultList = new HashMap<>(16);
        map.forEach((k, v) -> {
            System.out.println(v);
            Map<String ,Object> param = new HashMap<>(4);
            param.put("subjectId",paperQuestion.getSubjectId().toString()); // 所属科目
            param.put("paperId",paperQuestion.getPaperId().toString()); // 试卷id
            param.put("tableName",QuestionType.kv.get(k.toString()));// 通过map的key获取对应的表名
            param.put("questionType",k.toString()); // 试题类型
            // 将List<Long> 转成 List<Long> 再转成 String[]
            List<String> str = new ArrayList<>();
            v.stream().forEach(t-> str.add(String.valueOf(t)));
            param.put("questionIds", str.stream().toArray(String[]::new)); // 试题类型 sos 注意学习 mybatis 这种查询方式
            List<Question> result = combineService.list(param);
            // 将试题类型作为key  将其下试题作为value  便于前端 thymeleaf遍历
            resultList.put(k.toString(),result);
        });
        model.addAttribute("resultList", resultList);
        return "buzz/learn/paper/previewPaper";
    }

}
