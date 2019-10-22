package com.eurake.eurakeserver.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by disvenk.dai on 2018-09-21 17:05
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private Environment env;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable();
//        http.authorizeRequests().antMatchers("需要校验的url").hasRole("ADMIN")
//         .anyRequest().permitAll().and()
//         .formLogin().loginPage(env.getProperty("security.loginUrl","/login")).permitAll().and()
//         .logout().permitAll();

//                http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();

        //其实就是把 formLogin() 干掉了，又回到之前的 basic auth 认证方式
        //
        //---------------------
        //
        //本文来自 Java技术栈 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/youanyyou/article/details/81530240?utm_source=copy
        http.csrf().ignoringAntMatchers("/**").and().authorizeRequests().anyRequest()
                .authenticated().and().httpBasic();



 }

    }
