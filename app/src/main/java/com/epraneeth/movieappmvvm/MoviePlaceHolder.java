package com.epraneeth.movieappmvvm;

import com.epraneeth.movieappmvvm.models.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviePlaceHolder {
    @GET("2?")//?page=1&api_key=4056e9ab60d125ddec6ec2a67d91aea7/")
    Call<MovieResponse> getMovieResponse(@Query("page") String Page, @Query("api_key") String APIKey);
}
