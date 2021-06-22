package com.zhz.springcloud.service;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

/**
 * @Class: PaymentFallbackService
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2021-06-22 22:57
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentfallbackService  fall  paymentInfo_OK  /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentfallbackService  fall  paymentInfo_TimeOut  /(ㄒoㄒ)/~~";
    }
}
