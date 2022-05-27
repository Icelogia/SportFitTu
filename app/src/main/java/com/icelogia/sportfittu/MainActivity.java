package com.icelogia.sportfittu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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