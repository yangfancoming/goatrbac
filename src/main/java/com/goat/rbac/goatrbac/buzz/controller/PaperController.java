package com.goat.rbac.goatrbac.buzz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @GetMapping("preview")
    public String preview(Model model,PaperQuestion paperQuestion) {
        Map<String, List<Question>> resultList = getPaper(paperQuestion.getPaperId(), paperQuestion.getSubjectId());
        model.addAttribute("questions", resultList);
        model.addAttribute("paperId", paperQuestion.getPaperId());
        return "buzz/learn/paper/previewPaper";
    }


    @Autowired
    ICombineService combineService;

    public Map<String, List<Question>> getPaper(Long paperId, Long subjectId){
        List<PaperQuestion> paperQuestions = paperService.preview(paperId);
        // 将试卷中包含的所有试题，按照题型进行分组。分组后 key为 questionType value为当前试题类型下的题目 questionId
        Map<Integer, List<Long>> map = paperQuestions.stream().collect(groupingBy(x->x.getQuestionType(), mapping(x->x.getQuestionId(), toList())));
        Map<String, List<Question>> resultList = new HashMap<>(16);
        // 从题库表中取出 试卷中的所有试题，按照题型循环取出。
        map.forEach((k, v) -> {
            Map<String ,Object> param = new HashMap<>(4);
            param.put("subjectId",subjectId); // 所属科目
            param.put("paperId",paperId); // 试卷id
            param.put("tableName", QuestionType.kv.get(k.toString()));// 通过map的key获取对应的表名
            param.put("questionType",k.toString()); // 试题类型
            // 将List<Long> 转成 List<Long> 再转成 String[]
            List<String> str = new ArrayList<>();
            v.stream().forEach(t-> str.add(String.valueOf(t)));
            param.put("questionIds", str.stream().toArray(String[]::new)); // 试题类型 sos 注意学习 mybatis 这种查询方式
            // 通过 questionIds 取出所有试题
            List<Question> result = combineService.list(param);
            // 将试题类型作为key  将其下试题作为value  便于前端 thymeleaf遍历
            resultList.put(k.toString(),result);
        });
        return resultList;
    }

}
