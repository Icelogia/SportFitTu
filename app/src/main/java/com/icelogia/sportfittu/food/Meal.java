package com.icelogia.sportfittu.food;

import com.icelogia.sportfittu.MealItem;

import java.util.List;

public class Meal
{
    String name;
    List<Ingredient> ingredients;
    int carbons;
    int proteins;
    int fats;
    int kcal;

    public Meal(String name, List<Ingredient> ingredients)
    {
        this.name = name;
        this.ingredients = ingredients;
        setNutritions();
    }

    public String getName() {
        return name;
    }

    private void setNutritions()
    {
        this.carbons = 0;
        this.proteins = 0;
        this.fats = 0;
        this.kcal = 0;

        for(int x = 0; x < ingredients.size(); x++)
        {
            this.carbons += ingredients.get(x).getCarbons();
            this.proteins += ingredients.get(x).getProteins();
            this.fats += ingredients.get(x).getFats();
            this.kcal += ingredients.get(x).getKcal();
        }
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

    public MealItem toMealItem()
    {
        MealItem mealItem = new MealItem(this.name, this.carbons, this.proteins, this.fats);
        return mealItem;
    }
}
