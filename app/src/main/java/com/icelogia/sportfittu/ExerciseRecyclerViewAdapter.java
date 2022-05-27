package com.icelogia.sportfittu;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerciseRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseRecyclerViewAdapter.MyViewHolder>
{

    private Context context;
    private ArrayList<ExerciseItem> execises;

    public ExerciseRecyclerViewAdapter(Context context, ArrayList<ExerciseItem> execises)
    {
        this.context = context;
        this.execises = execises;
    }

    @NonNull
    @Override
    public ExerciseRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exercise_recycler_view_row, parent, false);

        return new ExerciseRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseRecyclerViewAdapter.MyViewHolder holder, int position)
    {
        holder.name.setText(execises.get(position).getName());

        holder.videoView.getSettings().setJavaScriptEnabled(true);
        holder.videoView.setWebChromeClient(new WebChromeClient());
        holder.videoView.loadUrl(execises.get(position).getPath());
        holder.videoView.getSettings().setSupportMultipleWindows(true);
        holder.videoView.getSettings().setSupportZoom(true);
        holder.videoView.getSettings().setBuiltInZoomControls(true);
        holder.videoView.getSettings().setAllowFileAccess(true);

        holder.videoView.setWebViewClient(new WebViewClient());
    }

    @Override
    public int getItemCount() {
        return execises.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private WebView videoView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewExerciseName);
            videoView = itemView.findViewById(R.id.webViewExercise);
        }

    }
}
