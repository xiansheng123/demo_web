package com.example.demo_web.service;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Log4j
public class LogFile {
    ThreadLocal<Long> startTime = new ThreadLocal<> ();

    @Pointcut("execution(public * com.example.demo_web.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void beforeTime() throws Throwable {
        startTime.set (System.currentTimeMillis ());
    }

    @AfterReturning("webLog()")
    public void afterTime() throws Throwable {
        log.info ("total use " + (System.currentTimeMillis () - startTime.get ()) + " s");
    }
}
