package com.jornah.bbbuserservice.service.impl;

import com.jornah.bbbuserservice.dao.RoleMapper;
import com.jornah.bbbuserservice.dao.UserMapper;
import com.jornah.bbbuserservice.service.UserService;
import com.jornah.biubiubiu.entity.Role;
import com.jornah.biubiubiu.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User getById(long id) {
        return userMapper.getById(id);
    }

    @Override
    public List<Role> getUserWithRole(String username) {
        return Optional.of(userMapper.getUserWithRole(username)).orElse(new User()).getRoles();
    }

    @Override
    public User getByUsername(String username) {
        logger.info("param usernmae :" + username);
        User user = userMapper.getByUsername(username);
        logger.info(user.getUsername(), user.getPassword());
        return user;
    }

    @Override
    public User addUser(User user) {
        userMapper.insert(user);
        User byUsername = userMapper.getByUsername(user.getUsername());
        if (Objects.nonNull(user.getRoles())) {
            user.getRoles().forEach(role -> userMapper.addRolesForUser(byUsername.getId(), role.getId()));
        }
        return null;
    }
}
