package com.academy.mindswap.sims.activity;

import com.academy.mindswap.sims.Messages;

public class Working extends Activity{

    public Working() {
        super(ActivityType.WORKING);
    }

    @Override
    public int doIt() {
        System.out.println(Messages.GO_TO_WORK);
        return 15;
    }
}
