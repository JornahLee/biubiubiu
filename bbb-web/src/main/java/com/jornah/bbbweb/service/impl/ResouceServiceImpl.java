package com.jornah.bbbweb.service.impl;

import com.jornah.bbbweb.dao.ResourceMapper;
import com.jornah.bbbweb.service.ResouceService;
import com.jornah.biubiubiu.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResouceServiceImpl implements ResouceService {

    @Autowired
    private ResourceMapper resMapper;
    @Override
    public Resource getByUrl(String url){
        return resMapper.getByUrl(url);
    }

}
