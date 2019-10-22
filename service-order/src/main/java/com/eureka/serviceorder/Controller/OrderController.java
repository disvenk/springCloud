package com.eureka.serviceorder.Controller;

import com.eureka.serviceorder.service.OrdermeMberService;
import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api("订单查询类接口")
@EnableSwagger2Doc
@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    private OrdermeMberService ordermeMberService;


    @GetMapping("getUserAll")
    public List<String> getUserAll(){
        System.out.println("走的是服务调用");
       return ordermeMberService.getUserAll();
    }

    @ApiOperation("订单服务接口")
    @ApiImplicitParam(name="userName",value = "用户信息参数",required = true,dataType = "String")
    @GetMapping("orderApi")
    public String oderApi(String userName){
        return "这是订单服务:"+userName;
    }
}
