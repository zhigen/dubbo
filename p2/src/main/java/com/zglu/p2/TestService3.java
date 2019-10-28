package com.zglu.p2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "3.0")
public class TestService3 implements com.zglu.api.TestService {

    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String test() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test3";
    }
}
