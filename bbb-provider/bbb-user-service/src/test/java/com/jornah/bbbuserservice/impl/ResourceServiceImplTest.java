package com.jornah.bbbuserservice.impl;

import com.jornah.bbbuserservice.service.impl.ResourceServiceImpl;
import com.jornah.biubiubiu.pojo.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest()
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ResourceServiceImplTest {
    @Autowired
    private ResourceServiceImpl resouceService;

    @Test
    public void testGetByUrl(){
        String url="/admin";
        Resource res = resouceService.getByUrl(url);
        System.out.println("--licg--- res  : " + res + "-----");
    }

}