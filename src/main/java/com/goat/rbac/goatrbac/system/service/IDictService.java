package com.goat.rbac.goatrbac.system.service;


import com.goat.rbac.goatrbac.system.model.Dict;

import java.util.List;

public interface IDictService  {

	List<Dict> findAllDicts(Dict dict);

	Dict findById(Long dictId);

	void addDict(Dict dict);

	void deleteDicts(String dictIds);

	void updateDict(Dict dicdt);
}
