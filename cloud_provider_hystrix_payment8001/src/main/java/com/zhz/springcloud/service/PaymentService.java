package com.zhz.springcloud.service;

/**
 * @Class: PaymentService
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2021-04-26 22:31
 */


public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

}
