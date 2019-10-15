package com.zglu.p;

import org.apache.dubbo.config.annotation.Service;

@Service
public class TestService implements com.zglu.api.TestService {

    @Override
    public String test() {
        return "test";
    }
}
