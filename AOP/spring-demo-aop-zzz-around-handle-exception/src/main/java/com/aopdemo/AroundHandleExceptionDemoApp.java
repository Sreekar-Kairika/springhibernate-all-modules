package com.aopdemo;

import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    public static Logger myLogger = Logger.getLogger(
            AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext
                (DemoConfig.class);

        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("Main Program : Around Demo App");

        myLogger.info("Calling Fortune");

        boolean tripWire = true;
        String data = theFortuneService.getFortune(tripWire);

        myLogger.info("\nMy Fortune is: " + data);

        myLogger.info("Finished");

        context.close();
    }
}
