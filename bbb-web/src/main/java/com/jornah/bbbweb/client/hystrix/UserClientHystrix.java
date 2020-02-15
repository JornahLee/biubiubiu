package com.jornah.bbbweb.client.hystrix;

import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientHystrix implements UserClient {
    @Override
    public User getByUid(Integer uid) {
        User usr = new User();
        usr.setUid(0);
        usr.setUsername("get user error");
        return usr;
    }

}
