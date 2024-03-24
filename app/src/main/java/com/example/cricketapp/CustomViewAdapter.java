package com.example.cricketapp;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

public interface CustomViewAdapter {
    @NonNull
    CustomViewAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    int getItemCount();
}
