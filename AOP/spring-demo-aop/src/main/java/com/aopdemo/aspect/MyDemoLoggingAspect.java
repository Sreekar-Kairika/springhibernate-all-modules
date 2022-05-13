package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices before logging

    //lets start with @Before Advice

//    @Before("execution(public void add*() )")

//    @Before("execution(* addAccount(com.aopdemo.Account,..) )")
//    public void beforeAddAccountAdvice(){
//        System.out.println("Executing @Before Advice method");
//    }

    @Before("execution(* com.aopdemo.dao.*.*(..) )")
            //Account.class.method(any method)
    public void beforeAddAccountAdvice(){
        System.out.println("Executing @Before Advice method");
    }

    @Before("execution(* addAccount(..))")
    public void beforeAddAccountAdvice1(){
        System.out.println("Executing @Before :: No Access Modifier ");

    }


}
