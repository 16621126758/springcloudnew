package com.zhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @Class: PaymentHystrixMain8001
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2021-04-26 22:29
 */
@SpringBootApplication
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }

}
