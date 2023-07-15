package com.academy.mindswap.sims.activity;

import com.academy.mindswap.sims.Messages;

public class Eating extends Activity{

    public Eating() {
        super(ActivityType.EATING);
    }

    @Override
    public int doIt() {
            System.out.println(Messages.IM_EATING);
            return 15;
        }

}
