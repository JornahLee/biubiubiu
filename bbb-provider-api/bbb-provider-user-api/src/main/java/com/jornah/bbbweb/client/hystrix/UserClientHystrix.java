package com.jornah.bbbweb.client.hystrix;

import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.pojo.Resource;
import com.jornah.biubiubiu.pojo.Role;
import com.jornah.biubiubiu.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<Role> getRolesOfUser(String username) {
        System.out.println("--licg--- getRolesOfUser   hystrix  hystrix hystrix: -----");
        return null;
    }

    @Override
    public Resource getByUrl(String url) {
        System.out.println("--licg--- getByUrl   hystrix  hystrix hystrix: -----");
        return null;
    }

}
