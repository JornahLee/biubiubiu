package com.jornah.bbbweb.service;

import com.jornah.biubiubiu.pojo.Resource;
import com.jornah.biubiubiu.pojo.Role;

import java.util.List;

public interface ResouceService {
    // 用了 role_resource 中间表
    // Mybatis sql怎么写先研究下
    Resource getByUrl(String url);

}
