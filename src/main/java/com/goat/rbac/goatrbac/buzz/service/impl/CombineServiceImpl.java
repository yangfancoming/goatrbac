package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.CombineMapper;
import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;
import com.goat.rbac.goatrbac.buzz.service.ICombineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
@Service
public class CombineServiceImpl implements ICombineService {

    @Autowired
    CombineMapper combineMapper;

    @Override
    public List<Question> list(Map map) {
        List<Question> list = combineMapper.list(map);
        return list;
    }

    @Override
    public int insert(PaperQuestion paperQuestion) {
        int insert = combineMapper.insert(paperQuestion);
        return insert;
    }

    @Override
    public int delete(PaperQuestion model) {
        int i = combineMapper.delete(model);
        return i;
    }
}
