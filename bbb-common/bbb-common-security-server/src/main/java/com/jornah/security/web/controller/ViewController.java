package com.jornah.security.web.controller;

import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.entity.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

    @Autowired
    UserClient userClient;
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "this is index page";
    }

    @RequestMapping("/testFeign/{id}")
    @ResponseBody
    public User testFeign(@PathVariable long id) {
        User user = userClient.getById(id);
        return user;
    }


    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String toLoginPage() {
        System.out.println("in meothod  login");
        // login 要做的事？
        // 访问login api 的时候，先判断是否有token（已登录），如果已登录，则直接跳转到首页
        //     此处应该使用一个filter实现，    或者拦截器实现
        // 如果没有登录，则访问SSO， 保存token
        // 然后 应该返回给前端什么呢？ 除了保存 token 到cookie中， 还有什么呢？
        // 浏览器响应会统一使用一个响应类， （记录请求核心数据，状态信息，错误代码等）
        return "login";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String login() {
        // 访问login api 的时候，先判断是否有token（已登录），如果已登录，则直接跳转到首页
        //     此处应该使用一个filter实现，或者拦截器实现
        // 如果没有登录，则访问SSO， 保存token
        // 然后 应该返回给前端什么呢？ 除了保存 token 到cookie中， 还有什么呢？
        // 浏览器响应会统一使用一个响应类， （记录请求核心数据，状态信息，错误代码等）
        return "hello its me";
    }

    @RequestMapping("/wf")
    @ResponseBody
    public String wf() {
        System.out.println("in meothod  login");
        // login 要做的事？
        // 访问login api 的时候，先判断是否有token（已登录），如果已登录，则直接跳转到首页
        //     此处应该使用一个filter实现，或者拦截器实现
        // 如果没有登录，则访问SSO， 保存token
        // 然后 应该返回给前端什么呢？ 除了保存 token 到cookie中， 还有什么呢？
        // 浏览器响应会统一使用一个响应类， （记录请求核心数据，状态信息，错误代码等）
        return "waht the fuck";
    }
}
