package com.zglu.p;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.1")
public class TestService11 implements com.zglu.api.TestService {

    @Override
    public String test() {
        return "P1test1.1";
    }
}
