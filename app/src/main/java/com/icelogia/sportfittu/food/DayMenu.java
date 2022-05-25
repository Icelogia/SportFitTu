package com.icelogia.sportfittu.food;

import com.icelogia.sportfittu.MealItem;

import java.util.ArrayList;
import java.util.Date;

public class DayMenu
{
    private Date date;
    private ArrayList<Meal> meals;
    int carbons;
    int proteins;
    int fats;
    int kcal;

    public DayMenu(Date date, ArrayList<Meal> meals)
    {
        this.date = date;
        this.meals = meals;
        setNutritions();
    }

    public Date getDate()
    {
        return date;
    }

    public ArrayList<Meal> getMeals()
    {
        return meals;
    }

    public void addMeal(Meal meal)
    {
        meals.add(meal);
        setNutritions();
    }

    public ArrayList<MealItem> getMealItems()
    {
        ArrayList<MealItem> mealItems = new ArrayList<>();

        for(int x = 0; x < meals.size(); x++)
        {
            MealItem mealItem = meals.get(x).toMealItem();
            mealItems.add(mealItem);
        }

        return mealItems;
    }

    private void setNutritions()
    {
        this.carbons = 0;
        this.proteins = 0;
        this.fats = 0;
        this.kcal = 0;

        for(int x = 0; x < meals.size(); x++)
        {
            this.carbons += meals.get(x).getCarbons();
            this.proteins += meals.get(x).getProteins();
            this.fats += meals.get(x).getFats();
            this.kcal += meals.get(x).getKcal();
        }
    }

    public String getCarbons() {
        return Integer.toString(this.carbons);
    }

    public String getProteins() {
        return Integer.toString(proteins);
    }

    public String getFats() {
        return Integer.toString(fats);
    }

    public String getKcal() {
        return Integer.toString(kcal);
    }
}
