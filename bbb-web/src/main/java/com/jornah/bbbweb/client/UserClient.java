package com.jornah.bbbweb.client;

import com.jornah.bbbweb.client.hystrix.UserClientHystrix;
import com.jornah.biubiubiu.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bbb-user-service",fallback = UserClientHystrix.class)
@RequestMapping("/user")
public interface UserClient {

    @RequestMapping("/user")
    User getByUid(@RequestParam(required = true) Integer uid);

    @RequestMapping("getByUsername")
    User getByUsername(@RequestParam(required = true) String username);
}
