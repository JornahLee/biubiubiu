package com.jornah.bbbweb.dao;

import com.jornah.biubiubiu.pojo.Role;

import java.util.List;

public interface RoleMapper {
    public List<Role> getRolesOfUser(String username);
}
