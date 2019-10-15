package com.zglu.c;

import com.zglu.api.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private TestService testService;

    @GetMapping
    public String test(){
        return testService.test();
    }
}
