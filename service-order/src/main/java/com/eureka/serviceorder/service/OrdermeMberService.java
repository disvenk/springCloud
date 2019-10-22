package com.eureka.serviceorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrdermeMberService {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getUserAll(){
        return restTemplate.getForObject("http://service-memeber/member",List.class);
    }
}
