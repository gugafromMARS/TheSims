package com.academy.mindswap.sims.activity;

import com.academy.mindswap.sims.Messages;

public class GoToBathroom extends Activity{

    public GoToBathroom() {
        super(ActivityType.GOTOBATHROOM);
    }

    @Override
    public int doIt() {
        System.out.println(Messages.IM_IN_TOILET);
        return 5;
    }
}
