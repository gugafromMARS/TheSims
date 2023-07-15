package com.academy.mindswap.sims.activity;

import com.academy.mindswap.sims.Messages;

public class Sleeping extends Activity{

    public Sleeping() {
        super(ActivityType.SLEEPING);
    }


    @Override
    public int doIt() {
        System.out.println(Messages.SLEEPING);
        return 100;
    }
}
