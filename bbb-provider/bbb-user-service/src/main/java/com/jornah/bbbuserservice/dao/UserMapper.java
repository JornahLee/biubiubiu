package com.jornah.bbbuserservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jornah.biubiubiu.entity.Role;
import com.jornah.biubiubiu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    User getById(long id);

    User getByUsername(String username);

    User getUserWithRole(String username);

    @Insert("insert into user_role(user_id,role_id) values(#{userId},#{roleId})")
    void addRolesForUser(@Param("userId") long userId,@Param("roleId") long roleId);
}
