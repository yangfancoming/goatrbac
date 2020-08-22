package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.FillQuestionMapper;
import com.goat.rbac.goatrbac.buzz.model.FillQuestion;
import com.goat.rbac.goatrbac.buzz.service.IFillQuestionService;
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
public class FillQuestionServiceImpl implements IFillQuestionService {

    @Autowired
    FillQuestionMapper fillQuestionMapper;

    @Override
    public int insert(FillQuestion question) {
        int insert = fillQuestionMapper.insert(question);
        return insert;
    }

    @Override
    public List<FillQuestion> find(FillQuestion question) {
        List<FillQuestion> devices = fillQuestionMapper.find(question);
        return devices;
    }

    @Override
    public void deleteByIds(String ids) {
        fillQuestionMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
}
