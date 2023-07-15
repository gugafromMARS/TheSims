package com.academy.mindswap.sims.houses;

public class LuxuryHouse extends House{

    public LuxuryHouse() {
        super(false, new Room[]{new Room(RoomType.BATHROOM), new Room(RoomType.BATHROOM), new Room(RoomType.BEDROOM), new Room(RoomType.BEDROOM), new Room(RoomType.KITCHEN),
                        new Room(RoomType.LIVING), new Room(RoomType.LIVING), new Room(RoomType.OFFICE), new Room(RoomType.OFFICE)},
                100000, HousesType.LUXURY);
    }
}
