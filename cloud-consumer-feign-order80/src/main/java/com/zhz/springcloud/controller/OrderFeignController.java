package com.zhz.springcloud.controller;

import com.zhz.springcloud.User;
import com.zhz.springcloud.entities.CommonResult;
import com.zhz.springcloud.entities.Payment;
import com.zhz.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> paymentById = paymentFeignService.getPaymentById(id);
        return paymentById;
    }

    @GetMapping(value = "/consumer/payment/getnnew/{id}")
    public CommonResult<Payment> getPaymentByIdnew(@PathVariable("id") Long id){
        User paymentById = paymentFeignService.getPaymentByIdnew(id);
        if (null!=paymentById){
            return new CommonResult<>(200,"查询成功,serverport:new"+ paymentById.toString());
        }else {
            List<String> list = new ArrayList<>();
            return new CommonResult<Payment>(444,"没有对应记录，查询失败",null);
        }
    }
}
