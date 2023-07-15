package com.academy.mindswap.sims.houses;

public class NormalHouse extends House{


    public NormalHouse() {
        super(false, new Room[]{new Room(RoomType.BATHROOM), new Room(RoomType.BEDROOM), new Room(RoomType.KITCHEN),
                new Room(RoomType.LIVING), new Room(RoomType.OFFICE)},
                15000, HousesType.NORMAL);
    }
}
