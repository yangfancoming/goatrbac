package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.CombineMapper;
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
    public List<Map> list(Map map) {
        List<Map> list = combineMapper.list(map);
        return list;
    }
}
