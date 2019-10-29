package com.zglu.p2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class P2Application {

    public static void main(String[] args) {
        SpringApplication.run(P2Application.class, args);
    }
}