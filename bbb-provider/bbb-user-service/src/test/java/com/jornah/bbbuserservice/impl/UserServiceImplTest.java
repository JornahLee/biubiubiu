package com.jornah.bbbuserservice.impl;

import com.jornah.bbbuserservice.service.UserService;
import com.jornah.bbbuserservice.service.impl.RoleServiceImpl;
import com.jornah.biubiubiu.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetRolesOfUser(){
        String username="admin";
        List<Role> role=userService.getByUsername(username).getRoles();
        System.out.println("--licg---   : " + role + "-----");
    }

}