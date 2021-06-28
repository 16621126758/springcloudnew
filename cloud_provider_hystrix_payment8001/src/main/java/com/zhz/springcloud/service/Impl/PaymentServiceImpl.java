package com.zhz.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhz.springcloud.service.PaymentService;
import javax.websocket.server.PathParam;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.PathVariable;
import sun.rmi.runtime.Log;

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
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")   //这个线程的超时时间为3秒钟
    })
    public String paymentInfo_TimeOut(Integer id)
    {
        //规定3秒钟正常，5秒异常  超过2秒应该有个兜底的方法。
        int timeNumber = 5;
//        try {
//            int age = 10/0;   //也会进入下面方法
//        } catch (Exception e) {
////            e.printStackTrace();     不会触发fallback
////           throw new RuntimeException("分子不能为0");   会触发fallback
//        }
        try { TimeUnit.MILLISECONDS.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:  "+Thread.currentThread().getName()+" paymentInfo_TimeOut id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): "+timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池:  "+Thread.currentThread().getName()+"8001系统繁忙或出错请稍后再试！ paymentInfo_TimeOutHandler id:  "+id+"\t"+"/(ㄒoㄒ)/~~";

    }


//    服务熔断-----------------------------
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
//            默认值20.意思是至少有20个请求才进行errorThresholdPercentage错误百分比计算。比如一段时间（10s）内有19个请求全部失败了。错误百分比是100%，
//            但熔断器不会打开，因为requestVolumeThreshold的值是20. 这个参数非常重要，熔断器是否打开首先要满足这个条件
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "20000"),  //时间窗口期  窗口期是经过多久后恢复一次尝试  短路多久以后开始尝试是否恢复，默认5s
//            隔10s之后，熔断器会尝试半开(关闭)，重新放进来请求
//            半开试探休眠时间，默认值5000ms。当熔断器开启一段时间之后比如5000ms，会尝试放过去一部分流量进行试探，确定依赖服务是否恢复。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
            //上面的意思是十次超过六次请求失败

    })
    public String paymentCircuitBreaker( Integer id){
        if (id < 0){
            throw new RuntimeException("********id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"/t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，/(ㄒoㄒ)/~~    id:" +id ;
    }


}
