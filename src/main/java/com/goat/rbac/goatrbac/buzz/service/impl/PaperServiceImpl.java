package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.PaperMapper;
import com.goat.rbac.goatrbac.buzz.model.FillQuestion;
import com.goat.rbac.goatrbac.buzz.model.Paper;
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

    @Override
    public int insert(Paper question) {
        int insert = paperMapper.insert(question);
        return insert;
    }

    @Override
    public List<Paper> find(Paper question) {
        List<Paper> devices = paperMapper.find(question);
        return devices;
    }

    @Override
    public void deleteByIds(String ids) {
        paperMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
}
