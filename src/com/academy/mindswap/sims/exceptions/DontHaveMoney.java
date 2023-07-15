package com.academy.mindswap.sims.exceptions;

import com.academy.mindswap.sims.Messages;

public class DontHaveMoney extends Exception{
    public DontHaveMoney() {
        super(Messages.DONT_HAVE_MONEY);
    }
}
