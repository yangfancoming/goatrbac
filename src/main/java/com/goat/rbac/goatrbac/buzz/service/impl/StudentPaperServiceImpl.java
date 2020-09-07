package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.StudentPaperMapper;
import com.goat.rbac.goatrbac.buzz.model.StudentPaper;
import com.goat.rbac.goatrbac.buzz.service.IStudentPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/9/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/9/7---11:03
 */
@Service
public class StudentPaperServiceImpl implements IStudentPaperService {


    @Autowired
    StudentPaperMapper studentPaperMapper;

    @Override
    public List<StudentPaper> find(StudentPaper question) {
        List<StudentPaper> studentPapers = studentPaperMapper.find(question);
        return studentPapers;
    }
}
