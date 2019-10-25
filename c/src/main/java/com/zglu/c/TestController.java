package com.zglu.c;

import com.zglu.api.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference(application = "p", version = "1.0")
    private TestService testService;
    @Reference(application = "p", version = "1.1")
    private TestService testService1;
    @Reference(application = "p2", version = "2.0")
    private TestService testService2;

    @GetMapping
    public String test() {
        return testService.test();
    }

    @GetMapping("/1")
    public String test1() {
        return testService1.test();
    }

    @GetMapping("/2")
    public String test2() {
        return testService2.test();
    }
}
