package com.jornah.bbbuserservice.service;

import com.jornah.biubiubiu.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolesOfUser(String username);

}
