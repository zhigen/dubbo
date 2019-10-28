package com.zglu.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class CRun {

    public static void main(String[] args) {
        SpringApplication.run(CRun.class);
    }
}