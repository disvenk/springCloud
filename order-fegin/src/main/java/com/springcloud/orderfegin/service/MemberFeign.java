package com.springcloud.orderfegin.service;

import com.springcloud.orderfegin.fallback.MemberFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "service-memeber",fallback = MemberFallback.class)//使用服务降级，服务请求异常后，会熔断到实现类
public interface MemberFeign {

    @RequestMapping("member")
    public List<String> getMember();

    @RequestMapping("memeberApi")
    public List<String> getMemberApi();
}