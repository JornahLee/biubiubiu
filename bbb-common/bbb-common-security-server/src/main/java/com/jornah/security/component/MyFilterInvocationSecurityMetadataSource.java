package com.jornah.security.component;

import com.jornah.bbbweb.client.ResourceClient;
import com.jornah.bbbweb.client.UserClient;
import com.jornah.biubiubiu.pojo.Resource;
import com.jornah.biubiubiu.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
//接收用户请求的地址，返回访问该地址需要的所有权限
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private UserClient resClient;
    private static Map<String, List<String>> attrConfig = new HashMap<>();

    static {
        attrConfig.put("/page1", Arrays.asList("ROLE_ADMIN", "ROLE_SUPER-ADMIN"));
        attrConfig.put("/page2", Arrays.asList("ROLE_NORMAL", "ROLE_TRIER"));
        attrConfig.put("/page3", Collections.singletonList("ROLE_LOGIN"));
        attrConfig.put("/wf", Collections.singletonList("ROLE_LOGIN"));
        attrConfig.put("/hello", Collections.singletonList("ROLE_LOGIN"));
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        //得到用户的请求地址,控制台输出一下
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("用户请求的地址是：" + requestUrl);


        if ("/login".equals(requestUrl)) {
            return null;
        } else {
            return SecurityConfig.createList(Optional.ofNullable(attrConfig.get(requestUrl)).orElse(Arrays.asList("ROLE_TRIER")).toArray(new String[0]));
        }


        // Resource resource = resClient.getByUrl(requestUrl);
        //
        // //如果没有匹配的url则说明大家都可以访问
        // if (resource == null) {
        //     return SecurityConfig.createList("ROLE_LOGIN");
        // }
        //
        // //将resource所需要到的roles按框架要求封装返回
        // List<Role> roles = resource.getRoleList();
        // int size = roles.size();
        // String[] values = new String[size];
        // for (int i = 0; i < size; i++) {
        //     values[i] = roles.get(i).getRoleName();
        // }
        // // 返回所需role
        // return SecurityConfig.createList(values);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}