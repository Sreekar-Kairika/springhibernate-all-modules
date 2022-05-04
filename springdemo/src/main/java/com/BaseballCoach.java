package com;

public class BaseballCoach implements Coach {

    //define a private field for Fortune Service
    private FortuneService fortuneService;

    //Cosntructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting practice";
    }

    public String getDailyFortune(){
        //use my fortune service
        return fortuneService.getFortune();
    }
}
