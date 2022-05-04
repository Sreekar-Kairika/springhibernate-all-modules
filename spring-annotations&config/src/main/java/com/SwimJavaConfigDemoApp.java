package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args){
        System.out.println("Hello world");

        //read spring config java file
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(SportConfig.class);
        //get bean from spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
        //call a method on the bean
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());

        //close the context
        context.close();
    }
}
