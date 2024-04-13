package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DoorTest {
    @Test
    void testDoorConstructor() {
        Door door = new Door();
        assertNotNull(door.getDoorContents());
    }
    @Test
    public void testDoorContentsLength() {
        Door door = new Door();
        String[] doorContents = door.getDoorContents();
        assertEquals(3, doorContents.length);
    }

    @Test
    public void testDoorContentsComposition() {
        Door door = new Door();
        String[] doorContents = door.getDoorContents();
        int carCount = 0;
        int goatCount = 0;

        for (String content : doorContents) {
            if (content.equals("car")) {
                carCount++;
            } else if (content.equals("goat")) {
                goatCount++;
            }
        }

        assertEquals(1, carCount);
        assertEquals(2, goatCount);
    }
}
