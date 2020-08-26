package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.SingleQuestionMapper;
import com.goat.rbac.goatrbac.buzz.model.SingleQuestion;
import com.goat.rbac.goatrbac.buzz.service.ISingleQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
