package com.jornah.bbbuserservice.dao;

import com.jornah.biubiubiu.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    public List<Role> getRolesOfUser(String username);
}
