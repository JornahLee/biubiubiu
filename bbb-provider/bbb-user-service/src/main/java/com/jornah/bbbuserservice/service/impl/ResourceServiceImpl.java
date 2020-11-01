package com.jornah.bbbuserservice.service.impl;

import com.jornah.bbbuserservice.dao.ResourceMapper;
import com.jornah.bbbuserservice.service.ResourceService;
import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resMapper;

    @Override
    public Resource getByUrl(String url) {
        return resMapper.getByUrl(url);
    }

    @Override
    public Resource addWithRoles(Resource res) {
        resMapper.insert(res);
        Resource resourceByUrl = resMapper.getByUrl(res.getUrl());
        if (Objects.nonNull(res.getRoles())) {
            //todo 应该一次批量插入，多次插入性能较低
            res.getRoles().forEach(role -> resMapper.addRoleForResource(role.getId(), resourceByUrl.getId()));
        }
        return null;
    }

    @Override
    public List<Role> getRolesByUrl(String url) {
        return Optional.ofNullable(resMapper.getByUrl(url))
                .orElse(new Resource()).getRoles();
    }

}
