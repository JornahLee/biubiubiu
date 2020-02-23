package com.jornah.bbbweb.client.hystrix;

import com.jornah.bbbweb.client.ResourceClient;
import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.pojo.Resource;

public class ResourceClientHystrix implements ResourceClient {
    @Override
    public Resource getByUrl(String url) {
        System.out.println("--licg---ResourceClientHystrix  getByUrl   hystrix  hystrix hystrix: -----");
        return null;
    }
}
