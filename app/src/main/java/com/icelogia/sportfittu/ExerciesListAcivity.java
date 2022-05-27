package com.icelogia.sportfittu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.icelogia.sportfittu.exercise.ExerciseDatabaseMock;

public class ExerciesListAcivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercies_list);

        ExerciseDatabaseMock exerciseDb = new ExerciseDatabaseMock();

        RecyclerView recyclerViewExercises = findViewById(R.id.exerciseListRecyclerView);
        ExerciseRecyclerViewAdapter exerciseAdapter = new ExerciseRecyclerViewAdapter(this, exerciseDb.downloadExercises());
        recyclerViewExercises.setAdapter(exerciseAdapter);
        recyclerViewExercises.setLayoutManager(new LinearLayoutManager(this));
    }




}