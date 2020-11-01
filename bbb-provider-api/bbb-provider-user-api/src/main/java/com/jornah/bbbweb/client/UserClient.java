package com.jornah.bbbweb.client;

import com.jornah.bbbweb.client.hystrix.UserClientHystrix;
import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;
import com.jornah.biubiubiu.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "bbb-user-service",fallback = UserClientHystrix.class)
public interface UserClient {

    @RequestMapping("/user/getById")
    User getById(@RequestParam() long id);

    @RequestMapping("/user/getByUsername")
    User getByUsername(@RequestParam() String username);

    @RequestMapping("/user/getUserWithRole")
    User getUserWithRole(@RequestParam() String username) ;

    // @RequestMapping("/resource/getRolesByUrl")
    // List<Role> getResourceRolesByUrl(@RequestParam String url) ;
    //
    // @RequestMapping("/resource/getByUrl")
    // Resource getResourceByUrl(@RequestParam String url) ;
}
