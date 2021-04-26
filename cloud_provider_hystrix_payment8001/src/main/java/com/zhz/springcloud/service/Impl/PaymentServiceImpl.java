package com.zhz.springcloud.service.Impl;

import com.zhz.springcloud.service.PaymentService;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Class: PaymentServiceImpl
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2021-04-26 22:32
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return  "线程池："+Thread.currentThread().getName()+"paymentInfo_OK, id = "+id+"/t"+"😊哈哈";
    }


    /**
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id)
    {
        int timeNumber = 3;
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): "+timeNumber;
    }





}
