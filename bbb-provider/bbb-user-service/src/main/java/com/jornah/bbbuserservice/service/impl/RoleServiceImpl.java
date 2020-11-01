package com.jornah.bbbuserservice.service.impl;

import com.jornah.bbbuserservice.dao.RoleMapper;
import com.jornah.bbbuserservice.service.RoleService;
import com.jornah.biubiubiu.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRolesOfUser(String username) {
        return roleMapper.getRolesOfUser(username);
    }
}
