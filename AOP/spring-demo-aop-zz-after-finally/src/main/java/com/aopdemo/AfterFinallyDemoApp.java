package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext
                (DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts = null;
//                theAccountDAO.findAccounts();

        try{
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception exc){
            System.out.println("In Main Program --- Caught Exception "+exc);
        }

        System.out.println("Main Program : After Throwing ");

        System.out.println(theAccounts);

        context.close();
    }
}
