package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.StudentPaper;

import java.util.List;

/**
 * Created by Administrator on 2020/9/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/9/7---10:59
 */
public interface StudentPaperMapper {

    List<StudentPaper> find(StudentPaper question);

}
