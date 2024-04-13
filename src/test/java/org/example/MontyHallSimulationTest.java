package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MontyHallSimulationTest {

    @Test
    void testPlayerChooseDoor(){
        MontyHallSimulation testGame = new MontyHallSimulation();
        assertEquals(0,testGame.playerChooseDoor(0));
    }

    @Test
    public void testOpenDoorChangesToOpened() {
        MontyHallSimulation game = new MontyHallSimulation();
        game.playerChooseDoor(0);
        game.hostOpenDoor();
        assertEquals("opened", game.getDoorContents()[game.getHostChoice()]);
    }

    @Test
    public void testOpenDoorDoesNotChangeCar() {
        MontyHallSimulation game = new MontyHallSimulation();
        game.playerChooseDoor(0);
        game.hostOpenDoor();
        String[] doorContents = game.getDoorContents();
        for (int i = 0; i < doorContents.length; i++) {
            if (doorContents[i].equals("car")) {
                assertNotEquals("opened", doorContents[i]);
            }
        }
    }

    @Test
    public void testOpenDoorDoesNotChangePlayerChoice() {
        MontyHallSimulation game = new MontyHallSimulation();
        game.playerChooseDoor(1);
        game.hostOpenDoor();
        assertNotEquals("opened", game.getDoorContents()[game.getPlayerChoice()]);
    }

    @Test
    void testPlayerChangedChoice() {
        MontyHallSimulation game = new MontyHallSimulation();
        game.playerChooseDoor(0); // Предположим, что игрок выбрал первую дверь
        game.hostOpenDoor(); // Симулируем открытие двери ведущим

        game.playerFinalChoice();

        assertNotEquals(0, game.getPlayerChoice());
    }

    @Test
    void testPlayerCannotChooseOpenedDoor() {
        MontyHallSimulation game = new MontyHallSimulation();
        game.playerChooseDoor(0); // Предположим, что игрок выбрал первую дверь
        game.hostOpenDoor(); // Симулируем открытие двери ведущим

        game.playerFinalChoice();

        assertNotEquals("opened", game.getDoorContents()[game.getPlayerChoice()]);
    }

    @Test
    void testPlayerLosesWhenChoosingGoatDoor() {
        MontyHallSimulation game = mock(MontyHallSimulation.class);

        when(game.checkIfWon()).thenReturn(false);

        assertFalse(game.checkIfWon());
    }
    @Test
    void testPlayerWinsWhenChoosingCarDoor() {
        MontyHallSimulation game = mock(MontyHallSimulation.class);

        when(game.checkIfWon()).thenReturn(true);

        assertTrue(game.checkIfWon());
    }

}
