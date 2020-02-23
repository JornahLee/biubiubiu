package com.jornah.bbbuserservice.controller;


import com.jornah.bbbuserservice.service.ResourceService;
import com.jornah.biubiubiu.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @RequestMapping("/resource/getByUrl")
    Resource getByUrl(String url) {
        return resourceService.getByUrl(url);
    }
}
