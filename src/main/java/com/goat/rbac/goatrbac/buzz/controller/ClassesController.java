package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.model.Classes;
import com.goat.rbac.goatrbac.buzz.model.Subject;
import com.goat.rbac.goatrbac.buzz.service.IClassesService;
import com.goat.rbac.goatrbac.buzz.service.ISubjectService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

// 班级类别
@RestController
@RequestMapping("classes")
public class ClassesController extends BaseController {

    @Autowired
    IClassesService classesService;

    @GetMapping("list")
    public Map<String, Object> deptList(QueryRequest request, Classes model) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Classes> results = classesService.find(model);
        PageInfo<Classes> pageInfo = new PageInfo<>(results);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    public ResponseBo addRole(Classes model) {
        model.setCreateTime(new Date());
        int insert = classesService.insert(model);
        return ResponseBo.ok("新增班级成功！" + insert);
    }

    @RequestMapping("delete")
    public ResponseBo delete(String ids) {
        classesService.deleteByIds(ids);
        return ResponseBo.ok("删除班级成功！");
    }

}
