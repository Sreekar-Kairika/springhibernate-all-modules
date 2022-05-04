package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemo {
    public static void main(String[] args){
        System.out.println("Hello world");

        //read spring config file
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //get bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        //call a method on the bean
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());

        //close the context
        context.close();
    }
}
