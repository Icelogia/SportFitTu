package com.icelogia.sportfittu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.icelogia.sportfittu.food.FoodDatabaseMock;
import com.icelogia.sportfittu.food.Meal;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity
{

    FoodDatabaseMock foodDatabaseMock;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        foodDatabaseMock = new FoodDatabaseMock();

        ArrayList<Meal> meals = foodDatabaseMock.downloadMeals();
        ArrayList<MealItem> mealItems = new ArrayList<>();

        for(int x = 0; x < meals.size(); x++)
        {
            Meal currentMeal = meals.get(x);
            MealItem mealItem = currentMeal.toMealItem();
            mealItems.add(mealItem);
        }

        RecyclerView recyclerViewMeals = findViewById(R.id.mealsListRecyclerView);
        MealRecyclerViewAdapter mealAdapter = new MealRecyclerViewAdapter(this, mealItems);
        recyclerViewMeals.setAdapter(mealAdapter);
        recyclerViewMeals.setLayoutManager(new LinearLayoutManager(this));
    }


}