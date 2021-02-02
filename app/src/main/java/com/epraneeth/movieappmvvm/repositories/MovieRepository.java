package com.epraneeth.movieappmvvm.repositories;

import androidx.lifecycle.MutableLiveData;

import com.epraneeth.movieappmvvm.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private static MovieRepository instance;
    private ArrayList<Movie> dataSet = new ArrayList<>();

    public static MovieRepository getInstance(){
        if(instance==null){
            instance = new MovieRepository();
        }
        return instance;
    }

    //pretend to get data from a web service
    public MutableLiveData<List<Movie>> getMovies(){
        setMovies();
        MutableLiveData<List<Movie>> data = new MutableLiveData<>();
        data.setValue(dataSet);//should be retrieved from API
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
