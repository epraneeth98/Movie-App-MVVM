package com.epraneeth.movieappmvvm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.epraneeth.movieappmvvm.R;
import com.epraneeth.movieappmvvm.models.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView originalTitle, voteAverage, overview;
    ImageView movieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        init();
    }

    private void init() {
        originalTitle = findViewById(R.id.movie_details_original_title);
        voteAverage = findViewById(R.id.movie_details_vote_average);
        overview = findViewById(R.id.movie_details_overview);
        movieImage = findViewById(R.id.movie_details_image);

        //Intent and set data in view
        Movie movie = (Movie)getIntent().getSerializableExtra("serializedMovie");
        originalTitle.setText(movie.getOriginal_title());
        voteAverage.setText(String.valueOf(movie.getVote_average()));
        overview.setText(movie.getOverview());
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + movie.getBackdrop_path())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(movieImage);
    }
}