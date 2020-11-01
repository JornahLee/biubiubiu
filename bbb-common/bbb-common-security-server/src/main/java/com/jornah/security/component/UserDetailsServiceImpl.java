package com.jornah.security.component;

import com.jornah.biubiubiu.entity.Role;
import com.jornah.biubiubiu.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    // @Autowired
    // private UserClient userClient;

    private static final Map<String,String> users=new HashMap<>();
    private static final Map<String, Role> userAuths=new HashMap<>();

    static {
        String pwd = new BCryptPasswordEncoder().encode("123");
        users.put("zhangsan",pwd);
        users.put("lisi",pwd);
        users.put("wangwu",pwd);
        users.put("zhaoliu",pwd);

        userAuths.put("zhangsan",Role.of("ROLE_ADMIN"));
        userAuths.put("lisi",Role.of("ROLE_SUPER-ADMIN"));
        userAuths.put("wangwu",Role.of("ROLE_USER"));
        userAuths.put("zhaoliu",Role.of("ROLE_USER-X"));

    }


    @Override
    //重写UserDetailsService接口里面的抽象方法
    //根据用户名 返回一个UserDetails的实现类的实例
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("查找用户：" + username);

        String pwd = users.get(username);

        if (StringUtils.isBlank(pwd)) {
            throw new UsernameNotFoundException("没有该用户");
        }
        // User user = userClient.getByUsername(username);
        // if (user == null) {
        //     throw new UsernameNotFoundException("没有该用户");
        // }

        //查到User后将其封装为UserDetails的实现类的实例供程序调用
        //用该User和它对应的Role实体们构造UserDetails的实现类
        User user=new User();
        user.setUsername(username);
        user.setPassword(pwd);

        return new UserDetailsImpl(user, Collections.singletonList(userAuths.get(username)));
        // return new UserDetailsImpl(user, userClient.getRolesOfUser(user.getUsername()));
    }
}
