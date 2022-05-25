package com.icelogia.sportfittu.food;

import com.icelogia.sportfittu.MealItem;

import java.util.ArrayList;
import java.util.Date;

public class DayMenu
{
    private Date date;
    private ArrayList<Meal> meals;


    public DayMenu(Date date, ArrayList<Meal> meals)
    {
        this.date = date;
        this.meals = meals;
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
}
