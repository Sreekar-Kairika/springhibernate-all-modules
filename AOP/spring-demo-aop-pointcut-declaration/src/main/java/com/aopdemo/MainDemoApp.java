package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args){

        //read spring config class
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DemoConfig.class);

        //get bean from container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        MembershipDAO theMemberDAO = context.getBean("membershipDAO",MembershipDAO.class);

        //call business method
        Account x = new Account();
        theAccountDAO.addAccount(x,true);




//        theMemberDAO.addMember();


        //close the context
        context.close();
    }
}



