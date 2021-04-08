package com.zhz.springcloud.service;

import com.zhz.springcloud.User;
import com.zhz.springcloud.entities.CommonResult;
import com.zhz.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
     @GetMapping("/payment/get/{id}")
     CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

     @GetMapping("/payment/get/{id}")  //这个也可以通，但是查询出来的时空的，因为查询出的结果与User不符合
     User getPaymentByIdnew(@PathVariable("id") Long id);
}
