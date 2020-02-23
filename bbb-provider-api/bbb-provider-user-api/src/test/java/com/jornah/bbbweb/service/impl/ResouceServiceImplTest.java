package com.jornah.bbbweb.service.impl;

import com.jornah.bbbweb.BBBWebApplication;
import com.jornah.bbbweb.dao.ResourceMapper;
import com.jornah.biubiubiu.pojo.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest(classes = BBBWebApplication.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ResouceServiceImplTest {
    @Autowired
    private ResouceServiceImpl resouceService;

    @Test
    public void testGetByUrl(){
        String url="/admin";
        Resource res = resouceService.getByUrl(url);
        System.out.println("--licg--- res  : " + res + "-----");
    }

}