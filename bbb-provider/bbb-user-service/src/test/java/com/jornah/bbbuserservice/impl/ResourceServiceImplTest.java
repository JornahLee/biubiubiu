package com.jornah.bbbuserservice.impl;

import com.jornah.bbbuserservice.service.impl.ResourceServiceImpl;
import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@SpringBootTest
public class ResourceServiceImplTest {
    @Autowired
    private ResourceServiceImpl resourceService;

    @Test
    public void testGetByUrl(){
        String url="/admin";
        Resource res = resourceService.getByUrl(url);
        List<Role> role = resourceService.getRolesByUrl(url);
        role.forEach(System.out::println);
        System.out.println("--licg--- res  : " + res + "-----");
    }

}