package com.springboot.demo.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    @GetMapping("/teaminfo")
    public String teamInfo(){
        return "Coach : " +coachName +" and Team Name : "+teamName;
    }
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!   Time on server is "+ LocalDateTime.now();
    }

    @GetMapping("/hello")
    public String sayHello1(){
        return "Hello Again";
    }

}
