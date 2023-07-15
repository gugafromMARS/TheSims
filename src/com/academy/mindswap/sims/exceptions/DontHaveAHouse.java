package com.academy.mindswap.sims.exceptions;

import com.academy.mindswap.sims.Messages;

public class DontHaveAHouse extends Exception{
    public DontHaveAHouse() {
        super(Messages.DONT_HAVE_A_HOUSE);
    }
}
