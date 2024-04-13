package org.example;

import java.util.Random;

public class MontyHallSimulation {
    private int playerChoice;
    private int hostChoice;
    private String[] doorContents;

    public int playerChooseDoor(int doorNumber) {
        playerChoice = doorNumber;
        return playerChoice;
    }

    public void hostOpenDoor() {
        Door doors = new Door();
        doorContents = doors.getDoorContents();
        Random random = new Random();
        do {
            hostChoice = random.nextInt(3);
        } while (hostChoice == playerChoice || doorContents[hostChoice].equals("car"));

        doorContents[hostChoice] = "opened"; // Открываем дверь с козой
    }

    // Финальный выбор игрока прописан так, потому что игрок умный и знает что вероятность победить больше, если выбор двери изменить)))
    public void playerFinalChoice() {
        for (int i = 0; i < doorContents.length; i++) {
            if (!doorContents[i].equals("opened") && i != playerChoice) {
                playerChoice = i;
                break;
            }
        }
    }

        public boolean checkIfWon() {
            return doorContents[playerChoice].equals("car");
        }

    public String[] getDoorContents() {
        return doorContents;
    }

    public int getPlayerChoice() {
        return playerChoice;
    }

    public int getHostChoice() {
        return hostChoice;
    }
}