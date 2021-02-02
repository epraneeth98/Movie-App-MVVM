package com.epraneeth.movieappmvvm.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.epraneeth.movieappmvvm.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.movie_image);
        textView = itemView.findViewById(R.id.movie_name);
    }
}

