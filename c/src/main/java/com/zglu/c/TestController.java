package com.zglu.c;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zglu.api.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference(version = "1.0")
    private TestService testService10;
    @Reference(version = "1.1")
    private TestService testService11;
    @Reference(version = "2.0")
    private TestService testService20;
    @Reference(version = "3.0")
    private TestService testService30;

    @GetMapping("/10")
    public String test() {
        return testService10.test();
    }

    @GetMapping("/11")
    public String test1() {
        return testService11.test();
    }

    @GetMapping("/20")
    public String test2() {
        return testService20.test();
    }

    @HystrixCommand(fallbackMethod = "timeOut")
    @GetMapping("/30")
    public String test3() {
        return testService30.test();
    }

    public String timeOut() {
        return "3.0无回应";
    }
}
