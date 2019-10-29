package com.zglu.p2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zglu.api.TestService2;
import lombok.extern.java.Log;
import org.apache.dubbo.config.annotation.Service;

@Log
@Service
public class TestService30 implements TestService2 {

    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String test(int milliseconds) {
        try {
            log.info("访问了");
            Thread.sleep(milliseconds);
            log.info("超时了");
        } catch (InterruptedException e) {
            log.info("超时了");
        }
        return "正常返回";
    }
}
