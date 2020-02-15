package com.jornah.bbbuserservice.service.impl;

import com.jornah.bbbuserservice.dao.UserMapper;
import com.jornah.bbbuserservice.service.UserService;
import com.jornah.biubiubiu.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUid(Integer uid) {
        return userMapper.getUserByUid(uid);
    }
}
