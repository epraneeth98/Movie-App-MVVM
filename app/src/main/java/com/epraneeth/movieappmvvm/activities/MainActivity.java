package com.epraneeth.movieappmvvm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.epraneeth.movieappmvvm.R;
import com.epraneeth.movieappmvvm.adapters.MovieAdapter;
import com.epraneeth.movieappmvvm.models.Movie;
import com.epraneeth.movieappmvvm.models.MovieResponse;
import com.epraneeth.movieappmvvm.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieResponse movieResponse;
    MovieAdapter movieAdapter;
    ArrayList<Movie> movieArrayList = new ArrayList<>();
    MainActivityViewModel mMainActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.themoviedb.org/4/list/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        MoviePlaceHolder moviePlaceHolderAPI = retrofit.create(MoviePlaceHolder.class);
//        Call<MovieResponse> call = moviePlaceHolderAPI.getMovieResponse("1","4056e9ab60d125ddec6ec2a67d91aea7");
//        call.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                Log.d("abc", "onResponse - Status : " + response.code());
//                movieResponse=response.body();
//                Log.d("abc", String.valueOf(movieResponse.getResults().size()));
//                movieArrayList.addAll(movieResponse.getResults());
//                movieAdapter.setData(movieArrayList);
//            }
//
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Log.d("abc", "Error Buddy!-"+ t.getMessage());
//            }
//        });

        movieAdapter = new MovieAdapter(this, movieArrayList);
        Log.d("abc", "In MainActivity");
        mMainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getMoviesLiveData().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                movieAdapter.changeData(movies);
                Log.d("abc", "In MainActivity Onchanged");
            }
        });

        //init 2
        recyclerView = findViewById(R.id.movies_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(movieAdapter);
    }
}