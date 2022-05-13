package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext
                (DemoConfig.class);

        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("Main Program : Around Demo App");

        System.out.println("Calling Fortune");

        String data = theFortuneService.getFortune();

        System.out.println("\nMy Fortune is: " + data);

        System.out.println("Finished");

        context.close();
    }
}
