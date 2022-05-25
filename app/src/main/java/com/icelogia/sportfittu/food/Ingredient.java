package com.icelogia.sportfittu.food;

public class Ingredient
{
    String name;
    int carbons;
    int proteins;
    int fats;
    int kcal;

    public Ingredient(String name, int carbons, int proteins, int fats)
    {
        this.name = name;
        this.carbons = carbons;
        this.proteins = proteins;
        this.fats = fats;
        this.kcal = 4 * carbons + 9 * fats + 4 * proteins;
    }

    public String getName() {
        return name;
    }

    public int getCarbons() {
        return carbons;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getKcal() {
        return kcal;
    }
}
