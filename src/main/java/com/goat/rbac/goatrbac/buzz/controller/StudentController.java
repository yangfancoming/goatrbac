package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.model.Classes;
import com.goat.rbac.goatrbac.buzz.model.Student;
import com.goat.rbac.goatrbac.buzz.service.IClassesService;
import com.goat.rbac.goatrbac.buzz.service.IStudentService;
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

// 学生管理
@RestController
@RequestMapping("student")
public class StudentController extends BaseController {

    @Autowired
    IStudentService studentService;

    @GetMapping("list")
    public Map<String, Object> deptList(QueryRequest request, Student model) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Student> results = studentService.find(model);
        PageInfo<Student> pageInfo = new PageInfo<>(results);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    public ResponseBo addRole(Student model) {
        model.setCreateTime(new Date());
        int insert = studentService.insert(model);
        return ResponseBo.ok("新增班级成功！" + insert);
    }

    @RequestMapping("delete")
    public ResponseBo delete(String ids) {
        studentService.deleteByIds(ids);
        return ResponseBo.ok("删除班级成功！");
    }

}
