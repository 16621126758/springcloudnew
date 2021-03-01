package com.zhz.springcloud.service;

import com.zhz.springcloud.entities.Payment;

public interface PaymentService {

    public abstract int createPayment(Payment payment);

    public abstract Payment getPaymentById( Long id);
}
