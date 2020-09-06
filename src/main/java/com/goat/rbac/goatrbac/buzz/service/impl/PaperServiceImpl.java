package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.common.QuestionType;
import com.goat.rbac.goatrbac.buzz.dao.PaperMapper;
import com.goat.rbac.goatrbac.buzz.dao.PaperQuestionMapper;
import com.goat.rbac.goatrbac.buzz.model.Paper;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;
import com.goat.rbac.goatrbac.buzz.service.ICombineService;
import com.goat.rbac.goatrbac.buzz.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
@Service
public class PaperServiceImpl implements IPaperService {


    @Autowired
    ICombineService combineService;

    @Autowired
    PaperMapper paperMapper;

    @Autowired
    PaperQuestionMapper paperQuestionMapper;

    @Override
    public int insert(Paper question) {
        return  paperMapper.insert(question);
    }

    @Override
    public List<Paper> find(Paper question) {
        return paperMapper.find(question);
    }

    @Override
    public int deleteByIds(String ids) {
        return paperMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }


    @Override
    public  List<PaperQuestion> preview(Long paperId) {
        return paperQuestionMapper.preview(paperId);
    }

    @Override
    public Map<String, List<Question>> getPaper(Long paperId, Long subjectId) {
        List<PaperQuestion> paperQuestions = preview(paperId);
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
