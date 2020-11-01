package com.jornah.bbbuserservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper extends BaseMapper<Resource> {
    Resource getByUrl(String url);
    List<Role> getRolesByUrl(String url);
    @Insert("insert into role_resource(role_id,resource_id) values(#{roleId},#{resourceId})")
    void addRoleForResource(@Param("roleId") long roleId,@Param("resourceId") long resourceId);
}
