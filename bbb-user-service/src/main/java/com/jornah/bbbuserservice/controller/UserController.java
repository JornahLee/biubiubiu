package com.jornah.bbbuserservice.controller;

import com.jornah.bbbuserservice.service.UserService;
import com.jornah.biubiubiu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getByUid")
    public User getByUid(Integer uid){
        System.out.println("bbbService uid :" + uid);
        return userService.getUserByUid(uid);
    }
    @RequestMapping("/getByUsername")
    User getByUsername(@RequestParam(required = true) String username){
        System.out.println("bbbService username :" + username);
        return userService.getByUsername(username);
    }
}
