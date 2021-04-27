package com.zhz.springcloud.service.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhz.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")   //这个线程的超时时间为3秒钟
    })
    public String paymentInfo_TimeOut(Integer id)
    {
        //规定3秒钟正常，5秒异常  超过2秒应该有个兜底的方法。
        int timeNumber = 1;
        int age = 10/0;   //也会进入下面方法
        try { TimeUnit.MILLISECONDS.sleep(timeNumber*1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:  "+Thread.currentThread().getName()+" paymentInfo_TimeOut id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): "+timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池:  "+Thread.currentThread().getName()+"系统繁忙请稍后再试！ paymentInfo_TimeOutHandler id:  "+id+"\t"+"/(ㄒoㄒ)/~~";

    }




}
