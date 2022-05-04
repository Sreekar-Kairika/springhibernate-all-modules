package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args){

        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //get bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        //call a method on the bean
        boolean result = (theCoach == alphaCoach);
        System.out.println("Pointing to same object  "+result);

        System.out.println("Memory location  "+theCoach);
        System.out.println("Memory location  "+alphaCoach);


        //close the context
        context.close();
    }
}

