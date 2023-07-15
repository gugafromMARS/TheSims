package com.academy.mindswap.sims.houses;

public class MediumHouse extends House{

    public MediumHouse() {
        super(false, new Room[]{new Room(RoomType.BATHROOM), new Room(RoomType.BEDROOM), new Room(RoomType.BEDROOM), new Room(RoomType.KITCHEN),
                new Room(RoomType.LIVING), new Room(RoomType.OFFICE)},
                30000, HousesType.MEDIUM);
    }
}
