package com.jornah.security.config;

import com.jornah.security.component.jwt.JwtAuthenticationTokenFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableWebSecurity // 注解开启Spring Security的功能
//WebSecurityConfigurerAdapter:重写它的方法来设置一些web的安全西街
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    {
        System.out.println("-----WebSecurityConfig 实例化了---------");
    }

    static {
        System.out.println("-----WebSecurityConfig 加载了---------");
    }

    @Autowired
    private UserDetailsService userDetailsService;

    //根据一个url请求，获得访问它所需要的roles权限
    @Autowired
    FilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

    //接收一个用户的信息和访问一个url所需要的权限，判断该用户是否可以访问
    @Autowired
    AccessDecisionManager myAccessDecisionManager;

    //403页面
    @Autowired
    AccessDeniedHandler myAccessDeniedHandler;

    /**
     * 定义认证用户信息获取来源，密码校验规则等
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**有以下几种形式，使用第3种*/
        // 1. inMemoryAuthentication 从内存中获取
        // auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("123").password(new BCryptPasswordEncoder().encode("123")).roles("USER");

        //2. jdbcAuthentication从数据库中获取，但是默认是以security提供的表结构
        //usersByUsernameQuery 指定查询用户SQL
        //authoritiesByUsernameQuery 指定查询权限SQL
        //auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);

        // 3. 注入userDetailsService，需要实现userDetailsService接口
        System.out.println("--licg---  maybe get userDetailsService : -----");
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("admin");
        System.out.println("--licg---  encode : " + encode + "-----");
    }

    //在这里配置哪些页面不需要认证
    @Override
    public void configure(WebSecurity web) throws Exception {
        // web.ignoring().antMatchers("/public/**", "/noAuthenticate", "/login");
    }

    /**
     * 定义安全策略
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // httpSecurity
        //         .formLogin() // 表单登录。跳转到security默认的登录表单页
        //         // http.httpBasic() //basic登录
        //         .and()
        //         .authorizeRequests() // 对请求授权
        //         .antMatchers("/noAuth").permitAll() //允许所有人访问/noAuth
        //         .anyRequest() // 任何请求
        //         .authenticated()// 需要身份认证
        // ;



        httpSecurity
                .authorizeRequests()
                // .antMatchers("/login","loginPage").permitAll()
                // .anyRequest().authenticated()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                //配置安全策略
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        return o;
                    }
                })

                // .and()
                // .sessionManagement()// 基于token，所以不需要session
                // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/process")

                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    StringBuffer sb = new StringBuffer();
                    sb.append("{\"status\":\"error\",\"msg\":\"");
                    if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
                        sb.append("用户名或密码输入错误，登录失败!");
                    } else if (e instanceof DisabledException) {
                        sb.append("账户被禁用，登录失败，请联系管理员!");
                    } else {
                        sb.append("登录失败!");
                    }
                    sb.append("\"}");
                    out.write(sb.toString());
                    out.flush();
                    out.close();
                })
                .successForwardUrl("/hello")
//                 .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
//                     httpServletResponse.setContentType("application/json;charset=utf-8");
//                     PrintWriter out = httpServletResponse.getWriter();
// //                        ObjectMapper objectMapper = new ObjectMapper();
//                     String s = "{\"status\":\"success\",\"msg\":" + "}";
//                     out.write(s);
//                     out.flush();
//                     out.close();
//                 })

                .and()
                .logout()
                .permitAll()

                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);

        // 禁用缓存
        // httpSecurity.headers().cacheControl();
        // 添加JWT filter
        // httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    //用autowired也是一样的吧
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }
}