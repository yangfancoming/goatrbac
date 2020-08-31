package com.goat.rbac.goatrbac.buzz.service;


import com.goat.rbac.goatrbac.buzz.model.PaperQuestion;
import com.goat.rbac.goatrbac.buzz.model.Question;

import java.util.List;
import java.util.Map;

public interface ICombineService {


    List<Question> list(Map map);

    int insert(PaperQuestion model);

    int delete(PaperQuestion model);


}
