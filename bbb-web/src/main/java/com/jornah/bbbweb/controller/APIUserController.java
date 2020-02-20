package com.jornah.bbbweb.controller;

import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class APIUserController {

    private Logger logger = LoggerFactory.getLogger(APIUserController.class);

    @Autowired
    private UserClient userClient;

    @RequestMapping("/user/getByUid")
    @ResponseBody
    public User getByUid(Integer uid) {
        System.out.println(" bbb web uid :" + uid);
        return userClient.getByUid(uid);
    }

    @RequestMapping("/user/login")
    public String login() {
        // login 要做的事？
        // 访问login api 的时候，先判断是否有token（已登录），如果已登录，则直接跳转到首页
        //     此处应该使用一个filter实现，或者拦截器实现
        // 如果没有登录，则访问SSO， 保存token
        // 然后 应该返回给前端什么呢？ 除了保存 token 到cookie中， 还有什么呢？
        // 浏览器响应会统一使用一个响应类， （记录请求核心数据，状态信息，错误代码等）
        return "login";
    }
    @RequestMapping("/user/getByUsername")
    @ResponseBody
    User getByUsername(@RequestParam(required = true) String username){
        System.out.println("bbbService username :" + username);
        return userClient.getByUsername(username);
    }

}
