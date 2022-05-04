package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;
//    @Autowired
//    public TennisCoach(FortuneService thefortuneService){
//        fortuneService = thefortuneService;
//    }
    //default constructor
    public TennisCoach(){
        System.out.println("Inside Default Constructor");
    }

    //init
//    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("Do my doMyStartupStuff");
    }

    //destroy
//    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("Do my doMyCleanupStuff ");
    }
    //setter
//    @Autowired
//    public void setFortuneService(FortuneService theFortuneService){
//        System.out.println("Inside Set Fortune service");
//        fortuneService =theFortuneService;
//    }
    @Override
    public String getDailyWorkout(){
        return "Practise your backend volley";
    }
    @Override
    public String getDailyFortune(){
        return fortuneService.getFortune();
    }


}
