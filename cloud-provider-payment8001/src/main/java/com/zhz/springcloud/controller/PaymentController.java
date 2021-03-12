package com.zhz.springcloud.controller;

import com.zhz.springcloud.entities.CommonResult;
import com.zhz.springcloud.entities.Payment;
import com.zhz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.createPayment(payment);
        if (result>0){
            return new CommonResult<Integer>(200,"消息插入数据库成功,serverport:"+serverPort,result);
        }else {
            return new CommonResult<Integer>(444,"消息插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (null!=paymentById){
            return new CommonResult<>(200,"查询成功,serverport"+serverPort,paymentById);
        }else {
            List<String> list = new ArrayList<>();
            return new CommonResult<Payment>(444,"没有对应记录，查询失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //相当于查询注册进了eureka 注册的信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info("----"+instance.getServiceId()+"/t"+instance.getHost()+"/t"+instance.getPort()+"/t"
            +instance.getUri());
        }
        return this.discoveryClient;

    }





}
