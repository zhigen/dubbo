package com.zglu.p2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "3.0")
public class TestService3 implements com.zglu.api.TestService {

    @Override
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    public String test() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test3";
    }
}
