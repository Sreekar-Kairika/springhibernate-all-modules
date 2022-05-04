package com;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] data = {
            "Peacock","parrot","Cat","Dog"
    };

    private Random myRandom = new Random();



    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        //random number based on size
        String ans = data[index];
        return ans;
    }
}
