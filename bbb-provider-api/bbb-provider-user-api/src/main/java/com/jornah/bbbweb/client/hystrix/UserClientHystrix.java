package com.jornah.bbbweb.client.hystrix;

import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientHystrix implements UserClient {
    @Override
    public User getByUid(Integer uid) {
        System.out.println("--licg--- getByUid   hystrix  hystrix hystrix: -----");
        User usr = new User();
        usr.setUid(0);
        usr.setUsername("get user error");
        return usr;
    }

    @Override
    public User getByUsername(String username) {
        System.out.println("--licg--- getByUsername   hystrix  hystrix hystrix: -----");
        return null;
    }

}
