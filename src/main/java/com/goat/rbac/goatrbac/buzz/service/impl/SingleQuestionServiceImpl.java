package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.SingleQuestionMapper;
import com.goat.rbac.goatrbac.buzz.model.SingleQuestion;
import com.goat.rbac.goatrbac.buzz.service.ISingleQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
@Service
public class SingleQuestionServiceImpl implements ISingleQuestionService {

    @Autowired
    SingleQuestionMapper singleQuestionMapper;

    @Override
    public int insert(SingleQuestion question) {
        // 获取选项    A. Who     B. Whose    C. What     D. Where
        String options = question.getQuestionOptions();
         /**  按照空串分隔
          0 = "A."
          1 = "Who"
          2 = "B."
          3 = "Whose"
          4 = "C."
          5 = "What"
          6 = "D."
          7 = "Where"
         */
        List<String> list = Arrays.asList(options.split(" "));
        // 将过滤后的选项 按照 - 分隔  拼接后  A.Who-B.Whose-C.What-D.Where-  插入表
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i%2!=0) {
                sb.append("-");
            }
        }
        // 干掉字符串最后一个字符 -
        question.setQuestionFormat(sb.toString().substring(0,sb.toString().length()-1));
        int insert = singleQuestionMapper.insert(question);
        return insert;
    }

    @Override
    public List<SingleQuestion> find(SingleQuestion question) {
        List<SingleQuestion> devices = singleQuestionMapper.find(question);
        return devices;
    }

    @Override
    public void deleteByIds(String ids) {
        singleQuestionMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
}
