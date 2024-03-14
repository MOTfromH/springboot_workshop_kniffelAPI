package com.mot.kniffel;

import java.util.Random;

public class roleTheDice {
    public static int rollTheDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;  // Generiert eine Zahl zwischen 1 und 6
    }

}
