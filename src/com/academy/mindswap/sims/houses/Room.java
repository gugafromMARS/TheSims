package com.academy.mindswap.sims.houses;

import com.academy.mindswap.sims.activity.*;

public class Room {

    private Activity activity;
    private RoomType type;
    private int cleanliness;

    public Room(RoomType type) {
        this.activity = activities(type);
        this.type = type;
        this.cleanliness = 100;
    }

    private Activity activities(RoomType type) {
        Activity availableActivity;
        switch (type) {
            default -> availableActivity = new Eating();
            case OFFICE -> availableActivity  = new Working();
            case LIVING -> availableActivity = new WatchingTV();
            case BEDROOM -> availableActivity = new Sleeping();
            case BATHROOM -> availableActivity = new GoToBathroom();
        };
        return activity = availableActivity;
    }

    public RoomType getType() {
        return type;
    }

    public Activity getActivity() {
        return activity;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public void decreaseCleanliness(int levelDecrease) {
        this.cleanliness -= levelDecrease;
    }

    @Override
    public String toString() {
        return "Room{" +
                "availableActivities=" + activity +
                ", type=" + type +
                '}';
    }
}
