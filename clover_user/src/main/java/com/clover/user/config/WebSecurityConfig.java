package com.clover.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jiangxin
 * @create 2019-01-15-11:46
 * 安全配置类,密码加密
 */
@Configuration        //配置类的注解
@EnableWebSecurity     //使用spring_boot的Security需要的注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests所有security全注解配置实现的开端，表示开始说明需要的权限。
        //需要的权限分两部分，第一部分是拦截的路径，第二部分访问该路径需要的权限。
        //antMatchers表示拦截什么路径，permitAll任何权限都可以访问，直接放行所有。
        //anyRequest()任何的请求，authenticated认证后才能访问
        //.and().csrf().disable();固定写法，表示使csrf拦截失效。
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
