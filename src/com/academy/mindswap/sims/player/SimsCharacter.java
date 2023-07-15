package com.academy.mindswap.sims.player;

import com.academy.mindswap.sims.Messages;
import com.academy.mindswap.sims.SimsGame;
import com.academy.mindswap.sims.activity.Activity;
import com.academy.mindswap.sims.activity.ActivityType;
import com.academy.mindswap.sims.activity.WorkingOut;
import com.academy.mindswap.sims.exceptions.*;
import com.academy.mindswap.sims.houses.House;
import com.academy.mindswap.sims.houses.HousesType;
import com.academy.mindswap.sims.houses.Room;
import com.academy.mindswap.sims.houses.RoomType;
import com.academy.mindswap.sims.maids.Maid;

public abstract class SimsCharacter {

    private String name;
    private Gender gender;
    private PersonalityType personality;
    private int maxEnergy;
    private int energyLevel;
    private double balance;
    private House house;

    public SimsCharacter(String name, PersonalityType personality, Gender gender, int energyLevel) {
        this.name = name;
        this.personality = personality;
        this.gender = gender;
        this.energyLevel = energyLevel;
        this.maxEnergy = energyLevel;
        this.balance = 25000.0;
        house = null;
    }

    public void buyHouse(HousesType type) throws AlreadyHaveHouse {
        House myHouse = SimsGame.playerBuyHouse(type);
            if(this.house == null) {
                if(myHouse != null) {
                    if(balance >= myHouse.getPrice()) {
                        this.house = myHouse;
                        balance -= myHouse.getPrice();
                        myHouse.setOccupied(true);
                        return;
                    }
                    System.out.println(Messages.DONT_HAVE_MONEY);
                    return;
                }
                System.out.println(Messages.AVAILABLE_HOUSES);
                return;
            }
            throw new AlreadyHaveHouse();
        }

    public House getHouse() {
        return house;
    }

    public void eat() {
        if (canDoIt()) {
            Room kitchen = availableRoom(RoomType.KITCHEN);
            if (kitchen != null) {
                if(kitchen.getCleanliness() >= 20) {
                    doTask(kitchen, ActivityType.EATING);
                    kitchen.decreaseCleanliness(20);
                    System.out.println(Messages.NEED_GO_TOILET);
                    goToToilet();
                    return;
                }
                System.out.println(Messages.CANT_USE_ROOM);
            }
        }
    }

    public void goToToilet() {
        Room toilet = availableRoom(RoomType.BATHROOM);
        if(toilet != null) {
            if(toilet.getCleanliness() >= 15) {
                doTask(toilet, ActivityType.GOTOBATHROOM);
                toilet.decreaseCleanliness(15);
                return;
            }
            System.out.println(Messages.CANT_USE_ROOM);
        }
    }

    public void goToSleep() {
        if(canDoIt()) {
            Room bedRoom = availableRoom(RoomType.BEDROOM);
            if(bedRoom != null) {
                if(bedRoom.getCleanliness() >= 15) {
                    doTask(bedRoom, ActivityType.SLEEPING);
                    bedRoom.decreaseCleanliness(15);
                    return;
                }
                System.out.println(Messages.CANT_USE_ROOM);
            }
        }
    }
    public void watchingTv() throws CantUseRoom {
        if(canDoIt()) {
            Room living = availableRoom(RoomType.LIVING);
            if(living != null) {
                if(living.getCleanliness() >= 20) {
                    doTask(living, ActivityType.WATCHINGTV);
                    living.decreaseCleanliness(20);
                    return;
                }
                throw new CantUseRoom();
            }
        }
    }
    public void goToWork() throws CantUseRoom {
        if (canDoIt()) {
           Room office = availableRoom(RoomType.OFFICE);
            if(office != null) {
                if(office.getCleanliness() >= 10) {
                    if(energyLevel >= 15) {
                        doTask(office, ActivityType.WORKING);
                        office.decreaseCleanliness(10);
                        balance += 2000;
                        return;
                    }
                    System.out.println(Messages.RESTORE_ENERGY);
                    return;
                }
                throw new CantUseRoom();
            }
        }
    }
    public void goWorkOut() throws RestoreEnergy {
        if(energyLevel >= 20) {
            Activity workOut = new WorkingOut();
            energyLevel -= workOut.doIt();
            return;
        }
        throw new RestoreEnergy();
    }
    private void doTask(Room room, ActivityType type) {
        Activity activity = room.getActivity();
        if(activity.getName() == ActivityType.WORKING || activity.getName() == ActivityType.WORKINGOUT){
            int energy = energyLevel - activity.doIt();
            calculateEnergy(energy);
            return;
        }
        int energy = energyLevel + activity.doIt();
        calculateEnergy(energy);
    }
    public void calculateEnergy(int energy) {
        if (energy <= maxEnergy) {
            energyLevel = energy;
        } else if(energy <= 0) {
            goToSleep();
        } else {
            energyLevel = maxEnergy;
        }
    }
    public void callMaid() throws DontHaveMoney {
        double payment = 500.0;
        if(balance >= payment) {
            balance -= payment;
            Maid Josefina = new Maid();
          house.welcomeMaid(Josefina);
          return;
        }
        throw new DontHaveMoney();
    }
    public Room availableRoom(RoomType roomType) {
       return house.getRoom(roomType);
    }

    public boolean canDoIt() {
        if(house != null) {
            if(!house.houseIsTooDirty()) {
                return true;
            }
            System.out.println(Messages.NEED_MAID);
            return false;
        }
        return false;
    }

    public void sellHouse() throws DontHaveAHouse {
        if(this.house != null) {
            System.out.println(Messages.SELL_HOUSE + house.getPrice() + "$");
            balance += house.getPrice();
            this.house.setOccupied(false);
            this.house = null;
            return;
        }
        throw new DontHaveAHouse();
    }

    public double getBalance() {
        return balance;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    @Override
    public String toString() {
        return "SimsCharacter{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", personality=" + personality +
                ", maxEnergy=" + maxEnergy +
                ", energyLevel=" + energyLevel +
                ", balance=" + balance +
                ", house=" + house +
                '}';
    }
}
