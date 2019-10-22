package com.springcloud.orderfegin.fallback;

import com.springcloud.orderfegin.service.MemberFeign;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberFallback implements MemberFeign{

    //这里数据服务降级，如果当MemberFeign中的getMember()调用出现等待超时
    //那么就会熔断降级，走这个备用方法，提示用户
    @Override
    public List<String> getMember() {
        List<String> list = new ArrayList<>();
        list.add("服务发生了错误1");
        return list;
    }

    @Override
    public List<String> getMemberApi() {
        List<String> list = new ArrayList<>();
        list.add("服务发生了错误2");
        return list;
    }
}
