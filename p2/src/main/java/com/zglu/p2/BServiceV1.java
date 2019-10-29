package com.zglu.p2;

import com.zglu.api.BService;
import lombok.extern.java.Log;
import org.apache.dubbo.config.annotation.Service;

@Log
@Service(version = "1.0", timeout = 1000)
public class BServiceV1 implements BService {

    @Override
    public String test(int milliseconds) {
        try {
            log.info("访问了");
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {

        }
        return "p2 BServiceV1 test(int)";
    }
}
