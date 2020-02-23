package com.jornah.bbbuserservice.service;


import com.jornah.biubiubiu.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserByUid(Integer uid );
    User getByUsername(String username);
}
