package com.zglu.p;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.1")
public class TestService1 implements com.zglu.api.TestService {

    @Override
    public String test() {
        return "test1";
    }
}
