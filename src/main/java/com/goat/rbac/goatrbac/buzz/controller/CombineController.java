package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.service.ICombineService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

// 组卷管理
@RestController
@RequestMapping("combine")
public class CombineController extends BaseController {

    @Autowired
    ICombineService combineService;

    @GetMapping("list")
    public Map<String, Object> list(QueryRequest request, @RequestParam Map<String ,Object> params ) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Map> devices = combineService.list(params);
        PageInfo<Map> pageInfo = new PageInfo<>(devices);
        return getDataTable(pageInfo);
    }

}
