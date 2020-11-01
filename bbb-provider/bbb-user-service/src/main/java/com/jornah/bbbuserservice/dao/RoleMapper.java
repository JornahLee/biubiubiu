package com.jornah.bbbuserservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jornah.biubiubiu.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRolesOfUser(String username);
}
