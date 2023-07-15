package com.academy.mindswap.sims.exceptions;

import com.academy.mindswap.sims.Messages;

public class RestoreEnergy extends Exception{

    public RestoreEnergy() {
        super(Messages.RESTORE_ENERGY);
    }
}
