package com.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //一定要加上这个注解不然配置不会自动更新的
public class ConfigController {

    @Value("${disvenk}")
    private String disvenk;

    @RequestMapping("/getDisvenk")
    public String config(){
        return disvenk;
    }

}
