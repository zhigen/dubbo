依次启动P1 P2 C<br>

访问http://172.16.50.199:8848/nacos 用户密码nacos:nacos 查看服务注册情况  

访问http://localhost:8801/swagger-ui.html 进行测试

P1里发布 AService 1.0，2.0版本，目的是测试服务不同版本<br>

P2里同样发布 AService 1.0版本，目的是联合p1测试dubbo内置负载均衡<br>

P2里发现 BService 1.0，2.0版本：<br>
　　1.0版本测试使用dubbo内置mock进行降级<br>
　　2.0版本测试集成Hystrix进行降级、熔断及熔断后重新尝试请求<br>
        