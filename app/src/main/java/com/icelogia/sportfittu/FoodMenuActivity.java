package com.icelogia.sportfittu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.icelogia.sportfittu.food.DayMenu;
import com.icelogia.sportfittu.food.FoodDatabaseMock;

import java.util.ArrayList;
import java.util.Calendar;

public class FoodMenuActivity extends AppCompatActivity
{
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private FoodDatabaseMock foodDb = new FoodDatabaseMock();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerMenu);
        dateButton.setText(getTodayDate());


        ArrayList<DayMenu> dayMenus = foodDb.downloadDayMenus();
        ArrayList<MealItem> breakfastMeals = dayMenus.get(0).getMealItems();
        ArrayList<MealItem> lunchMeals = dayMenus.get(1).getMealItems();
        ArrayList<MealItem> dinnerMeals = dayMenus.get(2).getMealItems();

        setMealRecyclerView(breakfastMeals, R.id.breakfastRecyclerView);
        setMealRecyclerView(lunchMeals, R.id.lunchRecyclerView);
        setMealRecyclerView(dinnerMeals, R.id.dinnerRecyclerView);
    }

    private void setMealRecyclerView(ArrayList<MealItem> items, int id)
    {
        RecyclerView recyclerViewMeals= findViewById(id);
        MealRecyclerViewAdapter mealAdapter = new MealRecyclerViewAdapter(this, items);
        recyclerViewMeals.setAdapter(mealAdapter);
        recyclerViewMeals.setLayoutManager(new LinearLayoutManager(this));
    }

    private String getTodayDate()
    {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);

                //ToDo: Update Menu for specific day
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year)
    {
        return  day + " " + getMonthFormat(month) + " " + year;
    }

    private String getMonthFormat(int month)
    {
        switch (month)
        {
            case 1:
                return "JAN";
            case 2:
                return "FEB";
            case 3:
                return "MAR";
            case 4:
                return "APR";
            case 5:
                return "MAY";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AUG";
            case 9:
                return "SEP";
            case 10:
                return "OCT";
            case 11:
                return "NOV";
            case 12:
                return "DEC";
            default:
                return "JAN";
        }
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}