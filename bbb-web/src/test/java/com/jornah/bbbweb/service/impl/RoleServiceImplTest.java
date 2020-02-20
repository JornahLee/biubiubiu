package com.jornah.bbbweb.service.impl;

import com.jornah.biubiubiu.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
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