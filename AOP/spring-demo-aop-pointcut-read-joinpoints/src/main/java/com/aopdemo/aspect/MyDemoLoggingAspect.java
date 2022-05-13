package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices before logging
    //let's start with @Before Advice

    @Before("com.aopdemo.aspect.LuvAOPExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println(" Executing Advice @Before  ");

        //display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        //display method arguments
        System.out.println("Method : " +methodSig );

        //display method Arguments

        //get args
        Object[] args = theJoinPoint.getArgs();
        //loop through args
        for(Object tempArgs:args){
            System.out.println(tempArgs);
            if(tempArgs instanceof Account){
                Account theAccount = (Account) tempArgs;

                System.out.println("account name "+theAccount.getName());
                System.out.println("account level "+theAccount.getLevel());

            }
        }
    }




}
