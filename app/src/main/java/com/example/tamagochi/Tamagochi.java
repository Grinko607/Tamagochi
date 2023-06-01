package com.example.tamagochi;

import java.io.Serializable;

public class Tamagochi implements Serializable {
    public static int hunger = 80;//голод
    public static int boredom = 80;//скука
    public static int fatigue = 80;//усталость
    public static int anger = 80;//гнев
    public static int disease = 80;//заболевание

    public Tamagochi(int hunger, int boredom, int fatigue, int anger, int disease) {
        Tamagochi.hunger = hunger;
        Tamagochi.boredom = boredom;
        Tamagochi.fatigue = fatigue;
        Tamagochi.anger = anger;
        Tamagochi.disease = disease;
    }
}
