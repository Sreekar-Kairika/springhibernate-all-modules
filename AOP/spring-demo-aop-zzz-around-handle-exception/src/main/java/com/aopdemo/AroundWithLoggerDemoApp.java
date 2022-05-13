package com.aopdemo;

import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    public static Logger myLogger = Logger.getLogger(
            AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext
                (DemoConfig.class);

        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("Main Program : Around Demo App");

        myLogger.info("Calling Fortune");

        String data = theFortuneService.getFortune();

        myLogger.info("\nMy Fortune is: " + data);

        myLogger.info("Finished");

        context.close();
    }
}
