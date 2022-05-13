package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogToCloudAsyncAspect {

    @Before("com.aopdemo.aspect.LuvAOPExpression.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(){
        System.out.println(" Logging to Cloud @Before ");
    }
}
