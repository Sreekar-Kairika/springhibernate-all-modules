package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices before logging
    //let's start with @Before Advice

    @Before("com.aopdemo.aspect.LuvAOPExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println(" Executing Advice @Before  ");
    }
}
