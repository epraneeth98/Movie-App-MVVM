package com.epraneeth.movieappmvvm.models;

import java.util.ArrayList;

public class MovieResponse {
    private ArrayList<Movie> results;

    public MovieResponse(ArrayList<Movie> results) {
        this.results = results;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}
