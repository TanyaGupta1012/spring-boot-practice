package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("In consructor: "+ getClass ().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }

    @Override
    public String getDailyWorkOut() {
        return null;
    }
}
