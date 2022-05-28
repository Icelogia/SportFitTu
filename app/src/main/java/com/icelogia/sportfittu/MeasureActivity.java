package com.icelogia.sportfittu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MeasureActivity extends AppCompatActivity
{
    private float chestMeasureVal = 0;
    private float bicpesMeasureVal = 0;
    private float bellyMeasureVal = 0;
    private float hipsMeasureVal = 0;
    private float thighsMeasureVal = 0;
    private boolean isInEditMode = false;

    TextView chestMeasure;
    TextView bicpesMeasure;
    TextView bellyMeasure;
    TextView hipsMeasure;
    TextView thighsMeasure;

    EditText chestMeasureInput;
    EditText bicpesMeasureInput;
    EditText bellyMeasureInput;
    EditText hipsMeasureInput;
    EditText thighsMeasureInput;

    Button editButton;
    Button cancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);

        chestMeasure = findViewById(R.id.textViewPreviousChestMeasure);
        bicpesMeasure = findViewById(R.id.textViewPreviousBicepsMeasure);
        bellyMeasure = findViewById(R.id.textViewPreviousBellyMeasure);
        hipsMeasure = findViewById(R.id.textViewPreviousHipsMeasure);
        thighsMeasure = findViewById(R.id.textViewPreviousThighsMeasure);
        chestMeasureInput = findViewById(R.id.editTextChest);
        bicpesMeasureInput = findViewById(R.id.editTextBiceps);
        bellyMeasureInput = findViewById(R.id.editTextBelly);
        hipsMeasureInput = findViewById(R.id.editTextHips);
        thighsMeasureInput = findViewById(R.id.editTextThighs);

        editButton = findViewById(R.id.buttonSaveEdit);
        cancelButton = findViewById(R.id.buttonCancel);
        switchInputs(isInEditMode);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!isInEditMode)
                {
                    editButton.setText("SAVE");
                    isInEditMode = true;

                }
                else
                {
                    editButton.setText("EDIT");
                    isInEditMode = false;
                    saveNewMeasures();
                    setNewMeasures();
                    clearEditInputs();
                }

                switchInputs(isInEditMode);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editButton.setText("EDIT");
                isInEditMode = false;
                switchInputs(isInEditMode);
                clearEditInputs();
            }
        });

    }

    private void saveNewMeasures()
    {
        String chestMeasureText = String.valueOf(chestMeasureInput.getText());
        if(!chestMeasureText.isEmpty())
            chestMeasureVal = Float.parseFloat(chestMeasureText);

        String bicpesMeasureText = String.valueOf(bicpesMeasureInput.getText());
        if(!bicpesMeasureText.isEmpty())
            bicpesMeasureVal = Float.parseFloat(bicpesMeasureText);

        String bellyMeasureText = String.valueOf(bellyMeasureInput.getText());
        if(!bellyMeasureText.isEmpty())
            bellyMeasureVal = Float.parseFloat(bellyMeasureText);

        String hipsMeasureText = String.valueOf(hipsMeasureInput.getText());
        if(!hipsMeasureText.isEmpty())
            hipsMeasureVal = Float.parseFloat(hipsMeasureText);

        String thighsMeasureText = String.valueOf(thighsMeasureInput.getText());
        if(!thighsMeasureText.isEmpty())
            thighsMeasureVal = Float.parseFloat(thighsMeasureText);

    }

    private void setNewMeasures()
    {
        if(chestMeasureVal != 0)
            chestMeasure .setText(String.valueOf(chestMeasureVal));

        if(bicpesMeasureVal != 0)
            bicpesMeasure.setText(String.valueOf(bicpesMeasureVal));

        if(bellyMeasureVal != 0)
            bellyMeasure.setText(String.valueOf(bellyMeasureVal));

        if(hipsMeasureVal != 0)
            hipsMeasure.setText(String.valueOf(hipsMeasureVal));

        if(thighsMeasureVal != 0)
            thighsMeasure.setText(String.valueOf(thighsMeasureVal));
    }

    private void clearEditInputs()
    {
        chestMeasureInput.setText("");
        bicpesMeasureInput.setText("");
        bellyMeasureInput.setText("");
        hipsMeasureInput.setText("");
        thighsMeasureInput.setText("");
    }

    private void switchInputs(boolean isEditable)
    {
        chestMeasureInput.setFocusableInTouchMode(isEditable);
        chestMeasureInput.setFocusable(isEditable);
        bicpesMeasureInput.setFocusableInTouchMode(isEditable);
        bicpesMeasureInput.setFocusable(isEditable);
        bellyMeasureInput.setFocusableInTouchMode(isEditable);
        bellyMeasureInput.setFocusable(isEditable);
        hipsMeasureInput.setFocusableInTouchMode(isEditable);
        hipsMeasureInput.setFocusable(isEditable);
        thighsMeasureInput.setFocusableInTouchMode(isEditable);
        thighsMeasureInput.setFocusable(isEditable);
    }
}