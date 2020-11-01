package com.jornah.bbbweb.client.hystrix;

import com.jornah.bbbweb.client.ResourceClient;
import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;

import java.util.List;

// todo 一个微服务 一个feign client
public class ResourceClientHystrix implements ResourceClient {
    @Override
    public List<Role> getRolesByUrl(String url) {
        System.err.println("--licg---ResourceClientHystrix  getRolesByUrl   hystrix  hystrix hystrix: -----");
        return null;
    }
    @Override
    public Resource getByUrl(String url) {
        System.err.println("--licg---ResourceClientHystrix  getByUrl   hystrix  hystrix hystrix: -----");
        return null;
    }
}
