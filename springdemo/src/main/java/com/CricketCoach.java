package com;

public class CricketCoach implements Coach{

    private String emailAddress;
    private String team;
    private FortuneService fortuneService;


    public void setEmailAddress(String emailAddress){
        System.out.println("Inside EMAIL Setter Method" );
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public void setTeam(String team){
        System.out.println("Inside TEAM  Setter Method" );
        this.team = team;
    }
    public String getTeam(){
        return team;
    }
    //create a no-arg constructor
    public CricketCoach(){
        System.out.println("Inside Cricket Coach Constructor");
    }

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("Inside Setter Method in Cricket Coach");
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout(){
        return " Practise fast bowling";
    }
    public String getDailyFortune(){
        return fortuneService.getFortune();
    }
}
