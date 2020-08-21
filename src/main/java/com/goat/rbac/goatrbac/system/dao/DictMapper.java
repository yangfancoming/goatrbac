package com.goat.rbac.goatrbac.system.dao;


import com.goat.rbac.goatrbac.system.model.Dict;

import java.util.List;

public interface DictMapper {

    Integer insert(Dict dict);

    List<Dict> findDictList(Dict dict);

    int deleteByIds(List<String> ids);
}