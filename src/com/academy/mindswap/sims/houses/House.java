package com.academy.mindswap.sims.houses;

import com.academy.mindswap.sims.Messages;
import com.academy.mindswap.sims.maids.Maid;

public abstract class House {

    private boolean occupied;
    private Room[] rooms;
    private double price;
    private HousesType type;
    private int maxLevelOfCleanliness;
    private int levelOfCleanliness;

    public House(boolean occupied, Room[] rooms, double price, HousesType type) {
        this.occupied = occupied;
        this.rooms = rooms;
        this.price = price;
        this.type = type;
        this.maxLevelOfCleanliness = rooms.length * 100;
        this.levelOfCleanliness = rooms.length * 100;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Room getRoom(RoomType roomType){
        for (Room room : rooms) {
            if (room.getType() == roomType) {
                if (room.getCleanliness() >= 40) {
                    return room;
                }
                return null; // como irá existir sempre a room, ele apenas chega a este null, dai eu dar o system.out no eat por cause de estar sujo.
            }
        }
        return null;
    }


    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public double getPrice() {
        return price;
    }

    public boolean houseIsTooDirty() {
        int levelOfDirt = 0;
        for(Room room : rooms) {
            levelOfDirt += room.getCleanliness();
        }
        if(levelOfDirt <= 250) {
            System.out.println(Messages.HOUSE_NEEDS_TO_BE_CLEANED);
            return true;
        }
        return false;
    }

    public void welcomeMaid(Maid maid) {
        System.out.println(Messages.MAID_IS_HERE);
        maid.setCleaning(true);
        for(Room room : rooms) {
            room.setCleanliness(100);
        }
        levelOfCleanliness = maxLevelOfCleanliness;
        maid.setCleaning(false);
    }

    public HousesType getType() {
        return type;
    }
}
