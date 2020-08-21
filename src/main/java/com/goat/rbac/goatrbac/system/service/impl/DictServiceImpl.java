package com.goat.rbac.goatrbac.system.service.impl;


import com.goat.rbac.goatrbac.system.dao.DictMapper;
import com.goat.rbac.goatrbac.system.model.Dict;
import com.goat.rbac.goatrbac.system.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DictServiceImpl implements IDictService {

	@Autowired
	private DictMapper dictMapper;

	@Override
	public List<Dict> findAllDicts(Dict dict) {
	    return dictMapper.findDictList(dict);
	}

	@Override
	public void addDict(Dict dict) {
		dictMapper.insert(dict);
	}

	@Override
	public void deleteDicts(String ids) {
        dictMapper.deleteByIds(Arrays.asList(ids.split(",")));
	}

	@Override
	public void updateDict(Dict dict) {

	}

	@Override
	public Dict findById(Long dictId) {
        return null;
	}

}
