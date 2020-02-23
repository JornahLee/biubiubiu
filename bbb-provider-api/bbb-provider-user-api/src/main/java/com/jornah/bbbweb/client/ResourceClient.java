package com.jornah.bbbweb.client;

import com.jornah.bbbweb.client.hystrix.ResourceClientHystrix;
import com.jornah.bbbweb.client.hystrix.UserClientHystrix;
import com.jornah.biubiubiu.pojo.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "bbb-user-service",fallback = ResourceClientHystrix.class)
public interface ResourceClient {

    @RequestMapping("/resource/getByUrl")
    Resource getByUrl(@RequestParam String url) ;
}
