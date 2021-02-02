package com.epraneeth.movieappmvvm.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.epraneeth.movieappmvvm.helpers.MoviePlaceHolder;
import com.epraneeth.movieappmvvm.models.Movie;
import com.epraneeth.movieappmvvm.models.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {
    private static MovieRepository instance;
    private MovieResponse movieResponse;
    private ArrayList<Movie> dataSet = new ArrayList<>();

    public static MovieRepository getInstance(){
        if(instance==null){
            instance = new MovieRepository();
        }
        return instance;
    }

    //pretend to get data from a web service
    public MutableLiveData<List<Movie>> getMovies(){

        MutableLiveData<List<Movie>> data = new MutableLiveData<>();

        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/4/list/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MoviePlaceHolder moviePlaceHolderAPI = retrofit.create(MoviePlaceHolder.class);
        Call<MovieResponse> call = moviePlaceHolderAPI.getMovieResponse("1", "4056e9ab60d125ddec6ec2a67d91aea7");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.d("abc", "onResponse - Status -: " + response.code());
                movieResponse = response.body();
                Log.d("abc", String.valueOf(movieResponse.getResults().size()));
                dataSet.addAll(movieResponse.getResults());
                data.setValue(dataSet);//should be retrieved from API
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("abc", "Error Buddy!-" + t.getMessage());
            }
        });
        Log.d("abc", "returning data in MovieRepo");
        return data;
    }

    private void setMovies(){
        for(int i=0; i<10; i++) {
            dataSet.add(new Movie("Praneeth Kumar",
                    "/uQ538BfYLDJh3GXlzRZLo0j7PFj.jpg",
                    "/uQ538BfYLDJh3GXlzRZLo0j7PFj.jpg",
                    "I am the overvoew",
                    4.5));
        }
    }
}
