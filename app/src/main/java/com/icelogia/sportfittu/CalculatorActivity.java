package com.icelogia.sportfittu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        EditText bmiWeightTextView = findViewById(R.id.editTextBMIWeight);
        EditText bmiHeightTextView = findViewById(R.id.editTextHeight);

        bmiWeightTextView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            public void afterTextChanged(Editable s) {
                calculateBMI(bmiWeightTextView, bmiHeightTextView);
            }
        });

        bmiHeightTextView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            public void afterTextChanged(Editable s) {
                calculateBMI(bmiWeightTextView, bmiHeightTextView);
            }
        });

    }


    private void calculateBMI( EditText bmiWeightTextView, EditText bmiHeightTextView)
    {

        TextView bmiResultTextView = findViewById(R.id.textViewBmiResult);

        String bmiWeightText = bmiWeightTextView.getText().toString();
        int bmiWeight = bmiWeightText.length() == 0 ?  0 : Integer.parseInt(bmiWeightText);

        String bmiHeightText = bmiHeightTextView.getText().toString();
        double bmiHeight = bmiHeightText.length() == 0 || bmiHeightText == "0" ?  1 : Integer.parseInt(bmiHeightText) * 0.01;

        if(!Float.isNaN(bmiWeight) && !Double.isNaN(bmiHeight))
        {
            double bmiValue = Float.parseFloat(String.valueOf(bmiWeight)) / (bmiHeight * bmiHeight);

            if(bmiValue < 18.50)
            {
                bmiResultTextView.setText("Result: " + "Underweight");
            }
            else if(bmiValue > 30)
            {
                bmiResultTextView.setText("Result: " + "Overweight");
            }
            else
            {
                bmiResultTextView.setText("Result: " + "Normal");
            }
        }
    }

}