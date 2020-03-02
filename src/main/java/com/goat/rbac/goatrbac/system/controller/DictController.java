package com.goat.rbac.goatrbac.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.system.model.Dict;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class DictController extends BaseController {

	@Autowired
	private IDictService dictService;

    @RequestMapping("dict/list")
    @ResponseBody
    public Map<String, Object> dictList(QueryRequest request, Dict dict) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Dict> list = dictService.findAllDicts(dict);
        PageInfo<Dict> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }


    @PostMapping("dict/add")
    @ResponseBody
    public ResponseBo addDict(Dict dict) {
        try {
            dictService.addDict(dict);
            return ResponseBo.ok("新增字典成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增字典失败，请联系网站管理员！");
        }
    }
}
