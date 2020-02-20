package com.jornah.bbbuserservice.dao;

import com.jornah.biubiubiu.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserByUid(Integer uid);

    User getByUsername(String username);
}
