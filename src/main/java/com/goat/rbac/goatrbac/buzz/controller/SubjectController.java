package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.model.Subject;
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

// 科目类别
@RestController
@RequestMapping("subject")
public class SubjectController extends BaseController {

    @Autowired
    ISubjectService subjectService;

    @GetMapping("list")
    public Map<String, Object> deptList(QueryRequest request, Subject question) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Subject> devices = subjectService.find(question);
        PageInfo<Subject> pageInfo = new PageInfo<>(devices);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    public ResponseBo addRole(Subject subject) {
        subject.setCreateTime(new Date());
        int insert = subjectService.insert(subject);
        return ResponseBo.ok("新增试题成功！" + insert);
    }

    @RequestMapping("delete")
    public ResponseBo delete(String ids) {
        subjectService.deleteByIds(ids);
        return ResponseBo.ok("删除试题成功！");
    }

}
