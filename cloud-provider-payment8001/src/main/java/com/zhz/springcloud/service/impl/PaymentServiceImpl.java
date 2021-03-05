package com.zhz.springcloud.service.impl;

import com.zhz.springcloud.dao.PaymentMapper;
import com.zhz.springcloud.entities.Payment;
import com.zhz.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentDao;

    @Override
    public int createPayment(Payment payment){
        System.out.println("hello");
        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }


}
