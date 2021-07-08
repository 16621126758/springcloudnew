package com.zhz.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Class: PaymentService
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2021-04-26 22:31
 */


public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);

    String paymentCircuitBreaker1(Integer id);

}
