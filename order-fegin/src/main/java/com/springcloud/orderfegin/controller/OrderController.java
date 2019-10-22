package com.springcloud.orderfegin.controller;

import com.springcloud.orderfegin.service.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private MemberFeign memberFeign;

    @RequestMapping("getMember1")
    public List<String> getMember1(){
        return memberFeign.getMember();
    }

    @RequestMapping("getMember2")
    public List<String> getMember2(){
        return memberFeign.getMemberApi();
    }
}
