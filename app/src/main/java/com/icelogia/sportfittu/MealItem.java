package com.icelogia.sportfittu;

public class MealItem
{
    String name;
    int carbons;
    int proteins;
    int fats;
    int kcal;

    public MealItem(String name, int carbons, int proteins, int fats)
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

    public String getCarbons() {
        return Integer.toString(carbons);
    }

    public String getProteins() {
        return Integer.toString(proteins);
    }

    public String getFats() {
        return Integer.toString(fats);
    }

    public String getKcal() {
        return Integer.toString(this.kcal);
    }
}
