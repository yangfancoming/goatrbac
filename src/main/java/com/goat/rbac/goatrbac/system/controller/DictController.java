package com.goat.rbac.goatrbac.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.system.model.Dict;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("dict")
public class DictController extends BaseController {

	@Autowired
	private IDictService dictService;

    @GetMapping("list")
    public Map<String, Object> list(QueryRequest request, Dict dict) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Dict> list = dictService.findAllDicts(dict);
        PageInfo<Dict> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    public ResponseBo add(Dict dict) {
        dictService.addDict(dict);
        return ResponseBo.ok("新增字典成功！");
    }

    @PostMapping("delete")
    public ResponseBo delete(String ids) {
        dictService.deleteDicts(ids);
        return ResponseBo.ok("删除字典成功！");
    }

    @PostMapping("ssex")
    public ResponseBo ssex(Dict dict) {
        List<Dict> dictKV = dictService.findDictKV(dict);
        return ResponseBo.ok(dictKV);
    }
}
