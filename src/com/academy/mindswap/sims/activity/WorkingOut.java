package com.academy.mindswap.sims.activity;

import com.academy.mindswap.sims.Messages;

public class WorkingOut extends Activity{

    public WorkingOut() {
        super(ActivityType.WORKINGOUT);
    }

    @Override
    public int doIt() {
        System.out.println(Messages.GO_WORKOUT);
        return 20;
    }
}
