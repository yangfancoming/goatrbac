package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.PaperMapper;
import com.goat.rbac.goatrbac.buzz.dao.PaperQuestionMapper;
import com.goat.rbac.goatrbac.buzz.model.Paper;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.service.IPaperService;
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
public class PaperServiceImpl implements IPaperService {

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

}
