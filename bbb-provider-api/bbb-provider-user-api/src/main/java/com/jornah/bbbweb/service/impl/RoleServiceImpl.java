package com.jornah.bbbweb.service.impl;

import com.jornah.bbbweb.dao.RoleMapper;
import com.jornah.bbbweb.service.RoleService;
import com.jornah.biubiubiu.pojo.Role;
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
