package com.zglu.p2;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0")
public class TestService10 implements com.zglu.api.TestService {

    @Override
    public String test() {
        return "P2test1.0";
    }
}
