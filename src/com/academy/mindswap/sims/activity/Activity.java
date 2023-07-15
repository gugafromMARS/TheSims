package com.academy.mindswap.sims.activity;

public abstract class Activity  {

    private ActivityType name;

    public Activity(ActivityType name) {
        this.name = name;
    }

    public ActivityType getName() {
        return name;
    }

    public int doIt() {
        System.out.println("im doing something");
        return 10;
    }


}
