package com.zglu.p2;

import com.zglu.api.AService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0")
public class AServiceV1 implements AService {

    @Override
    public String test() {
        return "p2 AServiceV1 test()";
    }
}
