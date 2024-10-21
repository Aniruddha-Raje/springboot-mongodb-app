package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class AOP {

    @Before("execution(public ResponseEntity<List<Customer>> com.example.controller.CustomerController.getAllCustomers())")
    public void logBefore(JoinPoint joinPoint) {

        log.info("logBefore() is running!");
        log.info("hijacked : " + joinPoint.getSignature().getName());
        log.info("******");
    }

    @After("execution(public ResponseEntity<List<Customer>> com.example.controller.CustomerController.getAllCustomers())")
    public void logAfter(JoinPoint joinPoint) {

        log.info("logAfter() is running!");
        log.info("hijacked : " + joinPoint.getSignature().getName());
        log.info("******");
    }
}
