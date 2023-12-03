package com.example.springtesttwin.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class BonCourageAspect {

    // Define a pointcut for methods in the services package starting with "get"
    @Pointcut("execution(* com.example.springtesttwin.services.*.gett*(..))")
    private void getMethods() {}

    // Apply the advice after the execution of methods matching the pointcut
    @After("getMethods()")
    public void bonCourageAdvice() {
        System.out.println("Bon courage!");
        log.info("Bon courage!");
    }
}