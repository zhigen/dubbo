package com.zglu.p2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zglu.api.BService;
import lombok.extern.java.Log;
import org.apache.dubbo.config.annotation.Service;

@Log
@Service(version = "2.0")
public class BServiceV2 implements BService {

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
        } catch (InterruptedException ignored) {

        }
        return "p2 BServiceV2 test(int)";
    }
}
