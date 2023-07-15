package com.academy.mindswap.sims.exceptions;
import com.academy.mindswap.sims.Messages;

public class AlreadyHaveHouse extends Exception{
    public AlreadyHaveHouse() {
        super(Messages.ALREADY_HAVE_HOUSE);
    }
}
