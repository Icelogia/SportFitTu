package com.icelogia.sportfittu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.icelogia.sportfittu.food.DayMenu;
import com.icelogia.sportfittu.food.FoodDatabaseMock;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FoodDatabaseMock foodDb = new FoodDatabaseMock();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button measuresButton = findViewById(R.id.buttonMeasures);
        Button menuButton = findViewById(R.id.buttonFoodMenu);
        Button recipesButton = findViewById(R.id.buttonRecipe);
        Button trainingPlanButton = findViewById(R.id.buttonTrainingPlan);
        Button exerciseListButton = findViewById(R.id.buttonExerciseList);
        Button calculatorButton = findViewById(R.id.buttonCalculator);

        assignButtonToPageNavigation(measuresButton, MeasureActivity.class);
        assignButtonToPageNavigation(menuButton, FoodMenuActivity.class);
        assignButtonToPageNavigation(recipesButton, RecipeActivity.class);
        assignButtonToPageNavigation(trainingPlanButton, TrainingPlanActivity.class);
        assignButtonToPageNavigation(exerciseListButton, ExerciesListAcivity.class);
        assignButtonToPageNavigation(calculatorButton, CalculatorActivity.class);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);


        if (isDarkModeOn)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        Switch darkModeSwitch = findViewById(R.id.switchDarkMode);

        darkModeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (darkModeSwitch.isChecked())
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean("isDarkModeOn", true);
                    editor.apply();
                }
                else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean("isDarkModeOn", false);
                    editor.apply();

                }
            }
        });

        ProgressBar carboProgressBar = findViewById(R.id.progressBarCarbo);
        ProgressBar proteinProgressBar = findViewById(R.id.progressBarProtein);
        ProgressBar fatProgressBar = findViewById(R.id.progressBarFats);

        ArrayList<DayMenu> dayMenus = foodDb.downloadDayMenus();

        int carbons = 0;
        int proteins = 0;
        int fats = 0;

        for(int x = 0; x < dayMenus.size(); x++)
        {
            DayMenu currentDayMenu = dayMenus.get(x);
            carbons += Integer.parseInt(currentDayMenu.getCarbons());
            proteins += Integer.parseInt(currentDayMenu.getProteins());
            fats  += Integer.parseInt(currentDayMenu.getFats());
        }

        carboProgressBar.setProgress(carbons / 6);
        proteinProgressBar.setProgress(proteins / 6);
        fatProgressBar.setProgress(fats / 6);


        MobileAds.initialize(this);

        AdView mAdView = findViewById(R.id.adManagerAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    private void assignButtonToPageNavigation(Button button, Class activityClass)
    {
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, activityClass);
                startActivity(intent);
            }
        });
    }
}