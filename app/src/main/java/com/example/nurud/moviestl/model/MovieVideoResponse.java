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

    public void setMovieId(int mMovieId) {
        this.mMovieId = mMovieId;
    }

    public List<MovieVideo> getResults() {
        return mResults;
    }

    public void setResults(List<MovieVideo> mResults) {
        this.mResults = mResults;
    }
}
