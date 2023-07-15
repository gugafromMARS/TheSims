package com.academy.mindswap.sims.exceptions;

import com.academy.mindswap.sims.Messages;

public class CantUseRoom extends Exception{
    public CantUseRoom() {
        super(Messages.CANT_USE_ROOM);
    }
}
