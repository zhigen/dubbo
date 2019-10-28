package com.zglu.p2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class Run2 {

    public static void main(String[] args) {
        SpringApplication.run(Run2.class, args);
    }
}