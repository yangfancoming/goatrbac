package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.QuestionMapper;
import com.goat.rbac.goatrbac.buzz.model.Question;
import com.goat.rbac.goatrbac.buzz.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public int insert(Question question) {
        int insert = questionMapper.insert(question);
        return insert;
    }

    @Override
    public List<Question> find(Question question) {
        List<Question> devices = questionMapper.find(question);
        return devices;
    }
}
