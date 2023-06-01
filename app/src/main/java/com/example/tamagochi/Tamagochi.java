package com.example.tamagochi;

import java.io.Serializable;

public class Tamagochi implements Serializable {
    public static int hunger = 50;//голод
    public static int boredom = 50;//скука
    public static int fatigue = 50;//усталость
    public static int anger = 50;//гнев
    public static int disease = 50;//заболевание

    public Tamagochi(int hunger, int boredom, int fatigue, int anger, int disease) {
        Tamagochi.hunger = hunger;
        Tamagochi.boredom = boredom;
        Tamagochi.fatigue = fatigue;
        Tamagochi.anger = anger;
        Tamagochi.disease = disease;
    }
}
