package com.jornah.bbbweb.security;

import com.jornah.bbbweb.service.RoleService;
import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private RoleService roleService;


    @Override
    //重写UserDetailsService接口里面的抽象方法
    //根据用户名 返回一个UserDetails的实现类的实例
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("查找用户：" + username);
        User user = userClient.getByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("没有该用户");
        }

        //查到User后将其封装为UserDetails的实现类的实例供程序调用
        //用该User和它对应的Role实体们构造UserDetails的实现类
        return new UserDetailsImpl(user, roleService.getRolesOfUser(user.getUsername()));
    }
}
