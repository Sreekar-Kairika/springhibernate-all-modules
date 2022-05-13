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
        x.setName("sreekar");
        x.setLevel("senior");
        theAccountDAO.addAccount(x,true);


//        theAccountDAO.setName("sreekar");
//        System.out.println(theAccountDAO.getName());
//        theAccountDAO.setServiceCode("gold");
//        System.out.println(theAccountDAO.getServiceCode());





        //close the context
        context.close();
    }
}



