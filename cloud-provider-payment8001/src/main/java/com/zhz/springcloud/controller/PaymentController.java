package com.zhz.springcloud.controller;

import com.zhz.springcloud.entities.CommonResult;
import com.zhz.springcloud.entities.Payment;
import com.zhz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.createPayment(payment);
        if (result>0){
            return new CommonResult<Integer>(200,"消息插入数据库成功",result);
        }else {
            return new CommonResult<Integer>(444,"消息插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (null!=paymentById){
            return new CommonResult<>(200,"查询成功",paymentById);
        }else {
            return new CommonResult<Payment>(444,"没有对应记录，查询失败",null);
        }
    }





}
