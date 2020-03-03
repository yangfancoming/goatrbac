package com.goat.rbac.goatrbac.system.controller;

import com.goat.rbac.goatrbac.system.model.ResponseBo;
import com.goat.rbac.goatrbac.system.service.IUserService;
import com.goat.rbac.goatrbac.system.util.MD5Utils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2020/2/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/26---16:14
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", getCurrentUser());
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password, String code, Boolean rememberMe) {
//        if (!StringUtils.isNotBlank(code)) {
//            return ResponseBo.warn("验证码不能为空！");
//        }
//        Session session = super.getSession();
//        String sessionCode = (String) session.getAttribute("_code");
//        if (!code.toLowerCase().equals(sessionCode)) {
//            return ResponseBo.warn("验证码错误！");
//        }
        password = MD5Utils.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        login(token);
        userService.updateLoginTime(username);
        return ResponseBo.ok();
    }
}
