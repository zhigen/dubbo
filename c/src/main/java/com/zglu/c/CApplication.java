package com.zglu.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class CApplication {

    public static void main(String[] args) {
        SpringApplication.run(CApplication.class);
    }
}