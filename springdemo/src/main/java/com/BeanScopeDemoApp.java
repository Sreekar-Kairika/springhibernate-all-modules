package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args){
        //load spring config file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach",Coach.class);
        Coach alphaCoach = context.getBean("myCoach",Coach.class);

        //Check if they are same beans
        boolean res = (theCoach == alphaCoach);
        //print result
        System.out.println(" Pointing to the same object ::"+res);
        System.out.println(" Memory location of  theCoach "+theCoach);
        System.out.println(" Memory location of  alphaCoach "+alphaCoach);

        //close
        context.close();
    }
}
