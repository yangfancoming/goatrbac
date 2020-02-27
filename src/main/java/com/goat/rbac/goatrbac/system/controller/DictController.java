package com.goat.rbac.goatrbac.system.controller;


import com.goat.rbac.goatrbac.system.model.Dict;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DictController extends BaseController {

	@Autowired
	private IDictService dictService;

    @RequestMapping("dict")
    public String index() {
        return "system/dict/dict";
    }

    @PostMapping("dict/add")
    @ResponseBody
    public ResponseBo addDict(Dict dict) {
        try {
            dictService.addDict(dict);
            return ResponseBo.ok("新增字典成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增字典失败，请联系网站管理员！");
        }
    }
}
