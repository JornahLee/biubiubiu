package com.jornah.bbbweb.service;

import com.jornah.biubiubiu.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolesOfUser(String username);

}
