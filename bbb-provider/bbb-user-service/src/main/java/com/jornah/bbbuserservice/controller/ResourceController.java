package com.jornah.bbbuserservice.controller;


import com.jornah.bbbuserservice.dao.ResourceMapper;
import com.jornah.bbbuserservice.service.ResourceService;
import com.jornah.biubiubiu.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    @Autowired
    ResourceMapper resourceMapper;

    @RequestMapping("/resource/getByUrl")
    Resource getByUrl(String url) {
        return resourceService.getByUrl(url);
    }

    @RequestMapping("/resource/getRolesByUrl")
    Resource getRolesByUrl(String url) {
        return resourceService.getByUrl(url);
    }

    @RequestMapping("/resource/addResource")
    @ResponseStatus(HttpStatus.CREATED)
    Resource addResource(@RequestBody  Resource res) {
        return resourceService.addWithRoles(res);
    }

    @RequestMapping("/resource/addRoleForResource")
    @ResponseStatus(HttpStatus.CREATED)
    void addRoleForResource(long roleId, long resourceId) {
        resourceMapper.addRoleForResource(roleId,resourceId);
    }
}
