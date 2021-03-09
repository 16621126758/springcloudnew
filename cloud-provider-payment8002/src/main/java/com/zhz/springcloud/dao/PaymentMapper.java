package com.zhz.springcloud.dao;

import com.zhz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {

    public abstract int createPayment(Payment payment);

    public abstract Payment getPaymentById(@Param("id") Long id);


}
