package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.model.Paper;
import com.goat.rbac.goatrbac.buzz.model.User;
import com.goat.rbac.goatrbac.buzz.service.IPaperService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

// 试卷管理
@Controller
@RequestMapping("paper")
public class PaperController extends BaseController {

    @Autowired
    IPaperService paperService;

    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> list(QueryRequest request, Paper model) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Paper> devices = paperService.find(model);
        PageInfo<Paper> pageInfo = new PageInfo<>(devices);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    @ResponseBody
    public ResponseBo add(Paper model) {
        model.setCreateTime(new Date());
        paperService.insert(model);
        return ResponseBo.ok("新增试题成功！");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseBo delete(String ids) {
        paperService.deleteByIds(ids);
        return ResponseBo.ok("删除试题成功！");
    }

    @GetMapping("/jump")
    public String jump(Model model) {
        model.addAttribute("userList", init2());
        return "buzz/learn/paper/previewPaper";
    }


    public List<User> init2(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("1", "yizhiwazi", "20170928"));
        userList.add(new User("2", "kumamon", "123456"));
        userList.add(new User("3", "admin", "admin"));
        return userList;
    }
}
