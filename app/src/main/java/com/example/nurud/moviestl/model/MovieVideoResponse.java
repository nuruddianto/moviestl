package com.example.nurud.moviestl.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SRIN on 12/28/2016.
 */
public class MovieVideoResponse {
    @SerializedName("id")
    private int mMovieId;
    @SerializedName("results")
    private List<MovieVideo> mResults;

    public int getMovieId() {
        return mMovieId;
    }

    public void setMovieId(int movieId) {
        this.mMovieId = movieId;
    }

    public List<MovieVideo> getResults() {
        return mResults;
    }

    public void setResults(List<MovieVideo> results) {
        this.mResults = results;
    }
}
