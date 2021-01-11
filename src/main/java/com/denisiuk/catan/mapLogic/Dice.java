package com.denisiuk.catan.mapLogic;

import java.util.Random;

public class Dice {

    public int diceRoll(){
        Random random = new Random();
        return random.nextInt(12)+1;
    }
}
