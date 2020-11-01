package com.jornah.security.component;

import com.jornah.bbbweb.client.ResourceClient;
import com.jornah.biubiubiu.entity.Resource;
import com.jornah.biubiubiu.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
//接收用户请求的地址，返回访问该地址需要的所有权限
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @javax.annotation.Resource
    private ResourceClient resourceClient;
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
        // todo login page 和首页 以及 错误页面 404 500页面无须权限
        // if ("/login".equals(requestUrl)) {
        //     return null;
        // }
        List<Role> roles = Optional.ofNullable(resourceClient.getByUrl(requestUrl))
                .map(Resource::getRoles).orElse(new ArrayList<>());
        // return SecurityConfig.createList(Optional.ofNullable(attrConfig.get(requestUrl)).orElse(Arrays.asList("ROLE_TRIER")).toArray(new String[0]));
        String[] configAttributes = roles.stream().map(Role::getRoleName).toArray(String[]::new);
        return SecurityConfig.createList(configAttributes);
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
