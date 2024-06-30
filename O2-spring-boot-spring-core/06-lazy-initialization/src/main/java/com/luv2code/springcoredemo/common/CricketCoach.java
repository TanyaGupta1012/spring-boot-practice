package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In consructor: "+ getClass ().getSimpleName());
    }



    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes. ";
    }

    @Override
    public String getDailyWorkOut() {
        return null;
    }
}
