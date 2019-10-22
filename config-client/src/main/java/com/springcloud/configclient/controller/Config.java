package com.springcloud.configclient.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by disvenk.dai on 2018-11-26 18:12
 */

@Configuration
public class Config {

    //如果说某一个类上加了@RefreshScope注解，这个类的属性是从yml里动态获取的，那么这个类在被其它地方使用的时候
    //如下这个方式那就应该在这个方法上加@RefreshScope注解
    //当这个类被注入到其它类当中的时候，其它类上要加@RefreshScope注解
    @Bean
    @RefreshScope
    public User user(){
        return new User();
    }
}
