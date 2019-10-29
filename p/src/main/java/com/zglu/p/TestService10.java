package com.zglu.p;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0")
public class TestService10 implements com.zglu.api.TestService {

    @Override
    public String test() {
        return "P1test1.0";
    }
}
