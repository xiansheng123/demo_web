package com.example.demo_web;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.validation.constraints.Max;
import java.util.*;

import static com.example.demo_web.service.ThreadTest.TestThread;


@SpringBootApplication
//@EnableCaching
//@EnableScheduling
public class DemoWebApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoWebApplication.class, args);
    }

}

