package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices before logging

    //let's start with @Before Advice


    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println(" Executing @Before Advice ");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println(" Performing API Analytics @Before ");
    }

}
