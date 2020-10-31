package com.jornah.security.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {


        //迭代器遍历目标url的权限列表
        Iterator<ConfigAttribute> iterator = collection.iterator();
        boolean allow = true;
        while (iterator.hasNext()) {
            ConfigAttribute ca = iterator.next();

            String needRole = ca.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)) {
                // 如果 authentication（验证） 是 AnonymousAuthenticationToken（匿名验证令牌）
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("未登录");
                } else
                    return;
            }

            //遍历当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //TODO 不对呀，意思说只要满足一个权限就可以了？ 万一一个资源需要多个权限呢？
                // 所以此处可以添加其他处理方式：比如实现需要同时需要多个权限
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        //执行到这里说明没有匹配到应有权限
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
