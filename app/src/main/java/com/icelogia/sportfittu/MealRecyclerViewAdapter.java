package com.icelogia.sportfittu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MealRecyclerViewAdapter extends RecyclerView.Adapter<MealRecyclerViewAdapter.MyViewHolder>
{
    private Context context;
    private ArrayList<MealItem> meals;

    public MealRecyclerViewAdapter(Context context, ArrayList<MealItem> meals)
    {
        this.context = context;
        this.meals = meals;
    }

    @NonNull
    @Override
    public MealRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.meal_recyler_view_row, parent, false);

        return new MealRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealRecyclerViewAdapter.MyViewHolder holder, int position)
    {
        holder.name.setText(meals.get(position).getName());
        holder.carbons.setText(meals.get(position).getCarbons());
        holder.proteins.setText(meals.get(position).getProteins());
        holder.fats.setText(meals.get(position).getFats());
        holder.kcals.setText(meals.get(position).getKcal());
    }

    @Override
    public int getItemCount()
    {
        return meals.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView name, carbons, proteins, fats, kcals;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewMealName);
            carbons = itemView.findViewById(R.id.textViewMealCarbons);
            proteins = itemView.findViewById(R.id.textViewMealProteins);
            fats = itemView.findViewById(R.id.textViewMealFats);
            kcals = itemView.findViewById(R.id.textViewMealKcals);
        }
    }
}
