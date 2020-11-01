package com.jornah.bbbuserservice.controller;

import com.jornah.bbbuserservice.dao.UserMapper;
import com.jornah.bbbuserservice.service.RoleService;
import com.jornah.bbbuserservice.service.UserService;
import com.jornah.biubiubiu.entity.Role;
import com.jornah.biubiubiu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getById")
    public User getById(long id){
        System.out.println("bbbService id :" + id);
        return userService.getById(id);
    }
    @RequestMapping("/getByUsername")
    User getByUsername(@RequestParam() String username){
        System.out.println("bbbService username :" + username);
        return userService.getByUsername(username);
    }
    @RequestMapping("/user/getUserWithRole")
    List<Role> getUserWithRole(@RequestParam() String username){
        return userService.getUserWithRole(username);
    }

    @RequestMapping("/user/addUserWithRole")
    @ResponseStatus(HttpStatus.CREATED)
    User addUserWithRole(@RequestBody User user){
        userService.addUser(user);
        return null;
        // return userService.getUserWithRole(username);
    }
}
