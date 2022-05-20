package com.springboot.demo.myCoolApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!   Time on server is "+ LocalDateTime.now();
    }

    @GetMapping("/name")
    public String sayName(){
        return "My name is Sreekar";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run Hard!!";
    }
    @GetMapping("/check")
    public String getChecked(){
        return "Check it Again !!";
    }
    @GetMapping("/hello")
    public String checkIt(){
        return "Hello Check !!";
    }

}
