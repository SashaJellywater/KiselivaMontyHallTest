package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int wins = 0;
        int losses = 0;
        MontyHallSimulation game = new MontyHallSimulation();
        game.playerChooseDoor(new Random().nextInt(3));
        game.hostOpenDoor();
        game.playerFinalChoice();

        for (int i = 0; i < 1000; i++) {
            game.playerChooseDoor(new Random().nextInt(3));
            game.hostOpenDoor();
            game.playerFinalChoice();

            if (game.checkIfWon()) {
                wins++;
            } else {
                losses++;
            }
        }

        System.out.println("Победы: " + wins);
        System.out.println("Поражения: " + losses);
    }
}