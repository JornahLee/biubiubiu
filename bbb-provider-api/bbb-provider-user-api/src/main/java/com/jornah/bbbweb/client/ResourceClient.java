package com.jornah.bbbweb.client;

import com.jornah.bbbweb.client.hystrix.ResourceClientHystrix;
import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "bbb-user-service",fallback = ResourceClientHystrix.class)
// todo 一个微服务 一个feign client
public interface ResourceClient {

    @RequestMapping("/resource/getRolesByUrl")
    List<Role> getRolesByUrl(@RequestParam String url) ;
    @RequestMapping("/resource/getByUrl")
    Resource getByUrl(@RequestParam String url) ;
}
