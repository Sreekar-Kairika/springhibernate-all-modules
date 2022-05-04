package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

public class JavaConfigDemoApp {
    public static void main(String[] args){
        System.out.println("Hello world");

        //read spring config java file
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(SportConfig.class);
        //get bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        //call a method on the bean
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());

        //close the context
        context.close();
    }
}
