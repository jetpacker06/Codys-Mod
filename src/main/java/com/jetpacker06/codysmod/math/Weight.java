package com.jetpacker06.codysmod.math;

import java.util.ArrayList;
import java.util.Random;

public class Weight {
    public record Pair(int chance, int value) {}

    public static int weighInts(Pair... ints) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (Pair i : ints) {
            for (int j=0;j<i.chance();j++) {
                integerArrayList.add(i.value());
            }
        }
        int indexChosen = new Random().nextInt(0, integerArrayList.size());
        return integerArrayList.get(indexChosen);
    }
}
