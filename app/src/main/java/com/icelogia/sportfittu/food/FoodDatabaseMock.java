package com.icelogia.sportfittu.food;

import java.util.ArrayList;
import java.util.Date;

public class FoodDatabaseMock
{
    public ArrayList<DayMenu> downloadDayMenus()
    {
        Date date = new Date();
        Meal meal0 = getExampleMeal();
        Meal meal1 = getExampleMeal();
        Meal meal2 = getExampleMeal();

        ArrayList<Meal> meals0 = new ArrayList<Meal>();
        meals0.add(meal0);
        meals0.add(meal2);

        ArrayList<Meal> meals1 = new ArrayList<Meal>();
        meals1.add(meal0);
        meals1.add(meal1);
        meals1.add(meal2);

        ArrayList<Meal> meals2 = new ArrayList<Meal>();
        meals2.add(meal0);

        DayMenu breakfast = new DayMenu(date, meals0);
        DayMenu lunch = new DayMenu(date, meals1);
        DayMenu dinner = new DayMenu(date, meals2);

        ArrayList<DayMenu> dayMenus = new ArrayList<DayMenu>();
        dayMenus.add(breakfast);
        dayMenus.add(lunch);
        dayMenus.add(dinner);

        return dayMenus;
    }


    public ArrayList<Meal> downloadMeals()
    {
        Meal meal0 = getExampleMeal();
        Meal meal1 = getExampleMeal();
        Meal meal2 = getExampleMeal();
        Meal ingredient0 = new Ingredient("Apple", 20, 20, 20);
        Meal ingredient1 = new Ingredient("Orange", 40, 20, 10);
        Meal ingredient2 = new Ingredient("Pear", 15, 20, 14);
        Meal ingredient3 = new Ingredient("Banana", 5, 6, 2);

        ArrayList<Meal> meals = new ArrayList<Meal>();
        meals.add(meal0);
        meals.add(meal1);
        meals.add(meal2);
        meals.add(ingredient0);
        meals.add(ingredient1);
        meals.add(ingredient2);
        meals.add(ingredient3);


        return meals;
    }
    private Meal  getExampleMeal()
    {
        Ingredient ingredient0 = new Ingredient("Apple", 20, 20, 20);
        Ingredient ingredient1 = new Ingredient("Orange", 40, 20, 10);
        Ingredient ingredient2 = new Ingredient("Pear", 15, 20, 14);
        Ingredient ingredient3 = new Ingredient("Banana", 5, 6, 2);

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(ingredient0);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);

        return new Meal("Fruit Salad", ingredients);
    }
}
