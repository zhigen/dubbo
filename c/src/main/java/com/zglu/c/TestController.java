package com.zglu.c;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zglu.api.AService;
import com.zglu.api.BService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference(version = "1.0")
    private AService aServiceV1;
    @Reference(version = "2.0")
    private AService aServiceV2;
    @Reference(version = "1.0", mock = "true")
    private BService bServiceV1;
    @Reference(version = "2.0")
    private BService bServiceV2;

    @ApiOperation("测试A服务V1版本，有负载均衡")
    @GetMapping("/a/v1")
    public String testV1() {
        return aServiceV1.test();
    }

    @ApiOperation("测试A服务V2版本")
    @GetMapping("/a/v2")
    public String testV2() {
        return aServiceV2.test();
    }

    @ApiOperation("测试B服务V1版本，通过mock降级")
    @GetMapping("/b/v1/{milliseconds}")
    @ApiImplicitParam(paramType = "path", dataType = "int", name = "milliseconds", value = "休眠毫秒数", required = true)
    public String testV1(@PathVariable int milliseconds) {
        return bServiceV1.test(milliseconds);
    }

    @ApiOperation("测试B服务V2版本，通过hystrix降级、熔断、重新尝试")
    @GetMapping("/b/v2/{milliseconds}")
    @ApiImplicitParam(paramType = "path", dataType = "int", name = "milliseconds", value = "休眠毫秒数", required = true)
    @HystrixCommand(fallbackMethod = "mock")
    public String testV2(@PathVariable int milliseconds) {
        return bServiceV2.test(milliseconds);
    }

    public String mock(int milliseconds) {
        return "TestController mock(int)";
    }
}
