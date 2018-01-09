package com.example.demo_web.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExcutorConfig {
@Bean
    ExecutorService executorService(){
    return Executors.newFixedThreadPool (3);
}
}
