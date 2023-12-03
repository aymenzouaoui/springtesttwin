package com.example.springtesttwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.example.springtesttwin", "com.example.springtesttwin.aspect"})

public class SpringtesttwinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtesttwinApplication.class, args);
    }

}
