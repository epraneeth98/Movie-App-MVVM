package com.epraneeth.movieappmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.epraneeth.movieappmvvm.models.Movie;
import com.epraneeth.movieappmvvm.repositories.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> mMoviesLiveData;
    private MovieRepository mRepo;

    public void init(){
        if(mMoviesLiveData != null){
            return ;
        }
        mRepo = MovieRepository.getInstance();
        mMoviesLiveData = mRepo.getMovies();
    }

    public LiveData<List<Movie>> getMoviesLiveData(){
        return mMoviesLiveData;
    }

}
