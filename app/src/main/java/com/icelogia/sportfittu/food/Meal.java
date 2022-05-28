package com.icelogia.sportfittu.food;

import com.icelogia.sportfittu.MealItem;

import java.util.ArrayList;
import java.util.List;

public class Meal
{
    protected String name;
    private List<Ingredient> ingredients;
    protected int carbons;
    protected int proteins;
    protected int fats;
    protected int kcal;

    public Meal(String name, int carbons, int proteins, int fats)
    {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
        this.carbons = carbons;
        this.proteins = proteins;
        this.fats = fats;
        this.kcal = 4 * carbons + 9 * fats + 4 * proteins;
    }

    public Meal(String name, List<Ingredient> ingredients)
    {
        this.name = name;
        this.ingredients = ingredients;
        setNutritions();
    }

    public String getName() {
        return name;
    }

    protected void setNutritions()
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
