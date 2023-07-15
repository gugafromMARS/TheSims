package com.academy.mindswap.sims;

import com.academy.mindswap.sims.exceptions.*;
import com.academy.mindswap.sims.houses.*;
import com.academy.mindswap.sims.maids.Maid;
import com.academy.mindswap.sims.player.*;

import java.util.Scanner;

public class SimsGame {

    private static House[] availableHouses;
    private Maid[] availableMaids;
    private SimsCharacter[] players;
    private static Scanner scanner;
    private boolean isPlaying = true;


    public SimsGame() {
        availableHouses = new House[]{new NormalHouse(),new NormalHouse(),new NormalHouse(),
                new MediumHouse(),new MediumHouse(),new MediumHouse(),
                new LuxuryHouse(), new LuxuryHouse(), new LuxuryHouse()};
        this.availableMaids = new Maid[] {new Maid(), new Maid(), new Maid(), new Maid(), new Maid()};
        this.scanner = new Scanner(System.in);
    }

    public void setPlayers(SimsCharacter[] players) {
        this.players = players;
    }


    public static House playerBuyHouse(HousesType houseType) {
        for(int i = 0; i < availableHouses.length; i++) {
            if(availableHouses[i].getType() == houseType) {
                if(!availableHouses[i].isOccupied()) {
                    return availableHouses[i];
                }
            }
        }
        return null;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public static SimsCharacter start() {
        SimsCharacter player;
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Gender : M (Male) or F (Female) ? ");
        String gender = scanner.nextLine();

        System.out.println("Personality ? F (Funny), L (Lazy) or S (Sporty) ?");
        String personality = scanner.nextLine();


         return createChar(name, gender, personality);
    }

    private static SimsCharacter createChar(String name, String gender, String personality) {
     SimsCharacter player = switch (personality) {
            default -> new SportyPlayer(name, checkGender(gender));
            case "F" -> new FunnyPlayer(name, checkGender(gender));
            case "L" -> new LazyPlayer(name, checkGender(gender));
        };
        return player;
    }


    private static Gender checkGender(String gender) {
        if(gender.contains("M")){
            return Gender.MALE;
        }
        return Gender.FEMALE;
    }

    public static void main(String[] args)  {

        SimsGame theSims = new SimsGame();

        while (theSims.isPlaying()) {
            SimsCharacter character1 = start();

            SimsCharacter[] players = {character1};

            theSims.setPlayers(players);

            System.out.println(character1);

            try {
                character1.buyHouse(HousesType.NORMAL);
                System.out.println(character1.getHouse());
            } catch (AlreadyHaveHouse e) {
                System.out.println(e);
            }

            //Testing methods
            System.out.println(character1.getEnergyLevel());
            character1.eat();
            System.out.println(character1.getEnergyLevel());

            try {
                character1.watchingTv();
            } catch (CantUseRoom e) {
                System.out.println(e);
            }

            try {
                character1.goToWork();
                System.out.println(character1.getBalance());
            } catch (CantUseRoom e) {
                System.out.println(e);
            }


            try {
                character1.goWorkOut();
                System.out.println(character1.getEnergyLevel());
            } catch (RestoreEnergy e) {
                System.out.println(e);
            }

            try {
                character1.callMaid();
            } catch (DontHaveMoney e) {
                System.out.println(e);
            }

            // Sell house and buy another one
            try {
                character1.sellHouse();
                System.out.println(character1.getBalance());
            } catch (DontHaveAHouse e) {
                System.out.println(e);
            }

            //tentar funcoes sem casa
            character1.eat();
            character1.goToSleep();


            theSims.isPlaying = false;
        }


    }
}
