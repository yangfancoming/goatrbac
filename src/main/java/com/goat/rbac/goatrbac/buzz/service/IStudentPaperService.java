package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.StudentPaper;

import java.util.List;


public interface IStudentPaperService {

    List<StudentPaper> find(StudentPaper question);

}
