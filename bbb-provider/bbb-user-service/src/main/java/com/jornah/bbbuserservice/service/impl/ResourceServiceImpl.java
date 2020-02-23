package com.jornah.bbbuserservice.service.impl;

import com.jornah.bbbuserservice.dao.ResourceMapper;
import com.jornah.bbbuserservice.service.ResourceService;
import com.jornah.biubiubiu.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resMapper;
    @Override
    public Resource getByUrl(String url){
        return resMapper.getByUrl(url);
    }

}
