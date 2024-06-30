package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependancy

    private Coach myCoach;
    private Coach anothercoach;

    @Autowired

    public DemoController(
            @Qualifier("cricketCoach") Coach thecoach,
            @Qualifier("cricketCoach") Coach theanotherother){
        System.out.println("In consructor: "+ getClass ().getSimpleName());
        myCoach = thecoach;
        anothercoach = theanotherother;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, "+ (myCoach == anothercoach);
    }
}
