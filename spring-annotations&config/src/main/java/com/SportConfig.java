package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //define bean for sad fortune
    // method name is bean id
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }
    //define bean for swim coach
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
