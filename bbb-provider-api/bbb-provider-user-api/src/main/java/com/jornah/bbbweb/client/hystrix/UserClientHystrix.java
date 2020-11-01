package com.jornah.bbbweb.client.hystrix;

import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;
import com.jornah.biubiubiu.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserClientHystrix implements UserClient {
    @Override
    public User getById(long id) {
        System.err.println("--licg--- getById   hystrix  hystrix hystrix: -----");
        User usr = new User();
        usr.setId(0L);
        usr.setUsername("get user error");
        return usr;
    }

    @Override
    public User getByUsername(String username) {
        System.err.println("--licg--- getByUsername   hystrix  hystrix hystrix: -----");
        return null;
    }

    @Override
    public User getUserWithRole(String username) {
        System.err.println("--licg--- getByUrl   hystrix  hystrix hystrix: -----");
        return null;
    }

    // @Override
    // public List<Role> getResourceRolesByUrl(String url) {
    //     System.err.println("--licg---ResourceClientHystrix  getRolesByUrl   hystrix  hystrix hystrix: -----");
    //     return null;
    // }
    // @Override
    // public Resource getResourceByUrl(String url) {
    //     System.err.println("--licg---ResourceClientHystrix  getByUrl   hystrix  hystrix hystrix: -----");
    //     return null;
    // }

}
