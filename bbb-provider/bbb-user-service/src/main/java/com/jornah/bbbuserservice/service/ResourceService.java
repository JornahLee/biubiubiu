package com.jornah.bbbuserservice.service;

import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;

import java.util.List;

public interface ResourceService {
    // 用了 role_resource 中间表
    // Mybatis sql怎么写先研究下
    Resource getByUrl(String url);
    Resource addWithRoles(Resource res);
    List<Role> getRolesByUrl(String url);


}
