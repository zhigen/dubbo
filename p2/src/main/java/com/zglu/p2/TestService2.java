package com.zglu.p2;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "2.0")
public class TestService2 implements com.zglu.api.TestService {

    @Override
    public String test() {
        return "test2";
    }
}
