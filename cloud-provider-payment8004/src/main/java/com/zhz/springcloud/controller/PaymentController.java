package com.zhz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPoart;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: "+serverPoart+"/t"+ UUID.randomUUID().toString();
    }

}
