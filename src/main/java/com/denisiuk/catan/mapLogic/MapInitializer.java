package com.denisiuk.catan.mapLogic;

import java.util.Arrays;
import java.util.Collections;

public class MapInitializer {

    public String[] initializeBoard(){

        String resourceArray[] = {"stone", "stone", "stone", "ore", "ore", "ore", "grain", "grain", "grain", "grain",
                "wood", "wood", "wood", "wood", "sheep", "sheep", "sheep", "sheep"};
        Collections.shuffle(Arrays.asList(resourceArray));
        return resourceArray;
    }
    public int[] initializeBoardNumbers(){
        int numberArray[] = {5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 8, 10, 9, 4, 5, 6, 11, 3};
        Collections.shuffle(Arrays.asList(numberArray));
        return numberArray;
    }
}