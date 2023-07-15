package com.academy.mindswap.sims.activity;

import com.academy.mindswap.sims.Messages;

public class WatchingTV extends Activity{

    public WatchingTV() {
        super(ActivityType.WATCHINGTV);
    }


    @Override
    public int doIt() {
        System.out.println(Messages.WATCHING_TV);
        return 10;
    }
}
