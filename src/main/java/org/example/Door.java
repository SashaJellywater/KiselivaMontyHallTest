package org.example;
import java.util.Random;

class Door {
    private String[] doorContents; // "car" - автомобиль, "goat" - коза

    public Door() {
        Random random = new Random();
        doorContents = new String[3];
        int carPosition = random.nextInt(3);
        doorContents[carPosition] = "car";
        for (int i = 0; i < 3; i++) {
            if (doorContents[i] == null) {
                doorContents[i] = "goat";
            }
        }
    }

    public String[] getDoorContents() {
        return doorContents;
    }
}