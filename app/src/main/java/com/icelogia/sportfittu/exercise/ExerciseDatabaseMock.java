package com.icelogia.sportfittu.exercise;

import com.icelogia.sportfittu.ExerciseItem;

import java.util.ArrayList;

public class ExerciseDatabaseMock
{
    public ArrayList<ExerciseItem> downloadExercises()
    {
        ExerciseItem exerciseItem = new ExerciseItem("Chloe Ting Summer", "https://www.youtube.com/watch?v=lX9XDNhxf54&list=PLAFs3kxY4h1-5WWhNYQtHAFeb_hVWXXrD&index=1&ab_channel=ChloeTing");
        ExerciseItem exerciseItem0 = new ExerciseItem("Genetycy Techniques", "https://www.youtube.com/watch?v=eMhIdSrCaqU&list=PLIUq4Uc_kUifHRWsvHWYz2C24i0mNmzdx&ab_channel=TomekGrzymski");
        ExerciseItem exerciseItem1 = new ExerciseItem("Chloe Ting ABS", "https://www.youtube.com/watch?v=AvWVYgzH_f4&ab_channel=ChloeTing");

        ArrayList<ExerciseItem> exerciseItems = new ArrayList<ExerciseItem>();
        exerciseItems.add(exerciseItem);
        exerciseItems.add(exerciseItem0);
        exerciseItems.add(exerciseItem1);

        return exerciseItems;
    }

}
