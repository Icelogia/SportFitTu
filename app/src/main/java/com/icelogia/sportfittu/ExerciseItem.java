package com.icelogia.sportfittu;

public class ExerciseItem
{
    String name;
    String path;

    public ExerciseItem(String name, String path)
    {
        this.name = name;
        this.path = path;
    }

    public String getName()
    {
        return name;
    }

    public String getPath()
    {
        return path;
    }
}
