package com.jornah.bbbuserservice.dao;

import com.jornah.biubiubiu.pojo.Resource;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMapper {
    Resource getByUrl(String url);
}
