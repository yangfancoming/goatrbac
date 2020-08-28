package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.SingleQuestionMapper;
import com.goat.rbac.goatrbac.buzz.model.SingleQuestion;
import com.goat.rbac.goatrbac.buzz.service.ISingleQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
@Service
public class SingleQuestionServiceImpl implements ISingleQuestionService {

    @Autowired
    SingleQuestionMapper singleQuestionMapper;


    @Override
    public int insert(SingleQuestion question) {
        // 获取选项    A. Who     B. Whose    C. What     D. Where
        String options = question.getQuestionOptions();
        // 按照空串分隔
        String[] s = options.split(" ");
        // 过滤掉 A. B. 等元素 和 空元素
        Stream<String> stringStream = Arrays.stream(s).filter((item)->item.indexOf(".") == - 1 && !item.isEmpty());
        // 拿到最终选项 Who Whose What Where
        List<String> collect = stringStream.collect(Collectors.toList());
        // 将过滤后的选项 按照 - 分隔  拼接后 Who-Whose-What-Where  插入表
        question.setQuestionFormat(String.join("-", collect));
        int insert = singleQuestionMapper.insert(question);
        return insert;
    }

    @Override
    public List<SingleQuestion> find(SingleQuestion question) {
        List<SingleQuestion> devices = singleQuestionMapper.find(question);
        return devices;
    }

    @Override
    public void deleteByIds(String ids) {
        singleQuestionMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
}
