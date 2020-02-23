package com.jornah.bbbweb.client;

import com.jornah.bbbweb.client.hystrix.UserClientHystrix;
import com.jornah.biubiubiu.pojo.Resource;
import com.jornah.biubiubiu.pojo.Role;
import com.jornah.biubiubiu.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "bbb-user-service",fallback = UserClientHystrix.class)
public interface UserClient {

    @RequestMapping("/user/getByUid")
    User getByUid(@RequestParam(required = true) Integer uid);

    @RequestMapping("/user/getByUsername")
    User getByUsername(@RequestParam(required = true) String username);

    @RequestMapping("/user/getRolesOfUser")
    List<Role> getRolesOfUser(@RequestParam(required = true) String username);

    @RequestMapping("/resource/getByUrl")
    Resource getByUrl(@RequestParam(required = true) String url) ;
}
