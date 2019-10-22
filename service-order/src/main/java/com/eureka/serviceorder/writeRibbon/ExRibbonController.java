package com.eureka.serviceorder.writeRibbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ExRibbonController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    private int reqCount = 1;//接口总请求数

    @RequestMapping("/ribbonMember")
    public String ribbonMember(){
        //获取对应服务器远程地址
        String instancesUrl = getInstances()+"/getMember";
        System.out.println("instanceUrl"+instancesUrl);
        //可以直接使用httpclient技术实现远程调用
        String result = restTemplate.getForObject(instancesUrl, String.class);
        return result;
    }

    public String getInstances(){
        List<ServiceInstance> instances = discoveryClient.getInstances("service-memeber");
        if(instances == null || instances.size()<=0){
            return null;
        }
        //获取服务器集群个数
        int instanceSize = instances.size();
        int serviceIndex = reqCount%instanceSize;
        reqCount++;
        return instances.get(serviceIndex).getUri().toASCIIString();
    }
}
