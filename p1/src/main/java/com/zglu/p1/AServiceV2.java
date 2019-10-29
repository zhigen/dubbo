package com.zglu.p1;

import com.zglu.api.AService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "2.0")
public class AServiceV2 implements AService {

    @Override
    public String test() {
        return "p1 AServiceV2 test()";
    }
}
