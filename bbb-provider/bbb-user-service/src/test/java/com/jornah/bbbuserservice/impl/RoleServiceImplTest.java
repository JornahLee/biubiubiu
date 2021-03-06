package com.jornah.bbbuserservice.impl;

import com.jornah.bbbuserservice.service.impl.RoleServiceImpl;
import com.jornah.biubiubiu.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    RoleServiceImpl roleService;

    @Test
    public void testGetRolesOfUser(){
        String username="admin";
        List<Role> role=roleService.getRolesOfUser(username);
        System.out.println("--licg---   : " + role + "-----");
    }

}