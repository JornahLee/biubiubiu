package com.jornah.bbbuserservice.service;


import com.jornah.biubiubiu.pojo.User;

public interface UserService {
    User getUserByUid(Integer uid );
    User getByUsername(String username);
}
