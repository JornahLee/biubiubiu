package com.jornah.bbbuserservice.service;

import com.jornah.biubiubiu.pojo.Resource;

public interface ResourceService {
    // 用了 role_resource 中间表
    // Mybatis sql怎么写先研究下
    Resource getByUrl(String url);

}
