package com.epraneeth.movieappmvvm.helpers;

import com.epraneeth.movieappmvvm.models.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviePlaceHolder {
    @GET("5?")
    Call<MovieResponse> getMovieResponse(@Query("page") String Page, @Query("api_key") String APIKey);
}
