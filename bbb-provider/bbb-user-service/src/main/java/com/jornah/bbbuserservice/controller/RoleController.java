package com.jornah.bbbuserservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jornah.bbbuserservice.dao.RoleMapper;
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

@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping("/getById")
    public Role getById(long id) {
        return roleMapper.selectById(id);
    }

    @RequestMapping("/allRole")
    List<Role> getUserWithRole() {
        return roleMapper.selectList(new QueryWrapper<>());
    }

    @RequestMapping("/addRole")
    @ResponseStatus(HttpStatus.CREATED)
    void addUserWithRole(@RequestBody Role role) {
        roleMapper.insert(role);
    }
}
