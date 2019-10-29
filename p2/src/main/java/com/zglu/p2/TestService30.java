package com.zglu.p2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.java.Log;
import org.apache.dubbo.config.annotation.Service;

@Log
@Service(version = "3.0")
public class TestService30 implements com.zglu.api.TestService {

    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String test() {
        try {
            log.info("访问了3.0");
            Thread.sleep(1100);
            log.info("超时了");
        } catch (InterruptedException e) {
            log.info("超时了");
        }
        return "P2test3.0";
    }
}
