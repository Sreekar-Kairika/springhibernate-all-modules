package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices before logging
    //let's start with @Before Advice

//    com.aopdemo.service.
    @Around("(execution(* com.aopdemo.service.*.getFortune(..) ))")
    public Object aroundGetFortune(ProceedingJoinPoint theproceedingJoinPoint) throws Throwable{

        //Print out method
        String method = theproceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>> Executing @Around  method "+method);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        //execute method
        Object result = theproceedingJoinPoint.proceed();
        // get end time stamp
        long end = System.currentTimeMillis();


        //complete duration display it
        long dur = end -begin;
        System.out.println("\n =====>> Duration  "+dur /1000.0 + " seconds");
        return result;
    }

    @After("(execution(* com.aopdemo.dao.AccountDAO.findAccounts(..) ))" )
    public void afterFinallyFindAccountAdvice(JoinPoint theJointPoint){

        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n =====>> Executing @After(finally) return method "+method);

    }

    @AfterThrowing(pointcut = "(execution(* com.aopdemo.dao.AccountDAO.findAccounts(..) ))",
             throwing ="theExc" )
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint ,
                                               Throwable theExc){
        System.out.println("\n =====>> Executing @Throwing return method "+theExc);
        System.out.println(theExc);
    }

    @AfterReturning(pointcut = "(execution(* com.aopdemo.dao.AccountDAO.findAccounts(..) ))",
    returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint,
                                                List<Account> result)
    {
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n =====>> Executing @After return method "+method);

        System.out.println("\n =====>> result is  "+result);

        if(result !=null ){
            Account temp = result.get(0);
            temp.setName("Pavan");
        }
        System.out.println("\n =====>> result is  "+result);

    }



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
