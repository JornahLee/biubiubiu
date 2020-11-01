package com.jornah.bbbuserservice.service;


import com.jornah.biubiubiu.entity.Role;
import com.jornah.biubiubiu.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getById(long id);

    List<Role> getUserWithRole(String username);

    User getByUsername(String username);

    User addUser(User user);
}
