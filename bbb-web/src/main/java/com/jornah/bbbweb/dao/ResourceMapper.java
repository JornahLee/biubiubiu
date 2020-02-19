package com.jornah.bbbweb.dao;

import com.jornah.biubiubiu.pojo.Resource;
import com.jornah.biubiubiu.pojo.Role;

import java.util.List;

public interface ResourceMapper {
    Resource getByUrl(String url);
}
