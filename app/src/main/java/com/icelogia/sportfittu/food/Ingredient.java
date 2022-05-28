package com.icelogia.sportfittu.food;

import java.util.ArrayList;

public class Ingredient extends  Meal
{
    String name;
    int carbons;
    int proteins;
    int fats;
    int kcal;

    public Ingredient(String name, int carbons, int proteins, int fats)
    {
        super(name, carbons, proteins, fats);
    }

    public String getName() {
        return name;
    }

//    public int getCarbons() {
//        return carbons;
//    }
//
//    public int getProteins() {
//        return proteins;
//    }
//
//    public int getFats() {
//        return fats;
//    }
//
//    public int getKcal() {
//        return kcal;
//    }
}
