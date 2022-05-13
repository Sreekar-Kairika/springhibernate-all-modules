package com.aopdemo.aspect;

import com.aopdemo.Account;
//import jdk.jpackage.internal.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
    
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //this is where we add all of our related advices before logging
    //let's start with @Before Advice

//    com.aopdemo.service.
    @Around("(execution(* com.aopdemo.service.*.getFortune(..) ))")
    public Object aroundGetFortune(ProceedingJoinPoint theproceedingJoinPoint) throws Throwable{

        //Print out method
        String method = theproceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n =====>> Executing @Around  method "+method);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        //execute method
        Object result = theproceedingJoinPoint.proceed();
        // get end time stamp
        long end = System.currentTimeMillis();


        //complete duration display it
        long dur = end -begin;
        myLogger.info("\n =====>> Duration  "+dur /1000.0 + " seconds");
        return result;
    }

    @After("(execution(* com.aopdemo.dao.AccountDAO.findAccounts(..) ))" )
    public void afterFinallyFindAccountAdvice(JoinPoint theJointPoint){

        String method = theJointPoint.getSignature().toShortString();
        myLogger.info("\n =====>> Executing @After(finally) return method "+method);

    }

    @AfterThrowing(pointcut = "(execution(* com.aopdemo.dao.AccountDAO.findAccounts(..) ))",
             throwing ="theExc" )
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint ,
                                               Throwable theExc){
        myLogger.info("\n =====>> Executing @Throwing return method "+theExc);
        myLogger.info(theExc.toString());
    }

    @AfterReturning(pointcut = "(execution(* com.aopdemo.dao.AccountDAO.findAccounts(..) ))",
    returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint,
                                                List<Account> result)
    {
        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n =====>> Executing @After return method "+method);

        myLogger.info("\n =====>> result is  "+result);

        if(result !=null ){
            Account temp = result.get(0);
            temp.setName("Pavan");
        }
        myLogger.info("\n =====>> result is  "+result);

    }



    @Before("com.aopdemo.aspect.LuvAOPExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info(" Executing Advice @Before  ");

        //display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        //display method arguments
        myLogger.info("Method : " +methodSig );

        //display method Arguments

        //get args
        Object[] args = theJoinPoint.getArgs();
        //loop through args
        for(Object tempArgs:args){
            myLogger.info(tempArgs.toString());
            if(tempArgs instanceof Account){
                Account theAccount = (Account) tempArgs;

                myLogger.info("account name "+theAccount.getName());
                myLogger.info("account level "+theAccount.getLevel());

            }
        }
    }




}
