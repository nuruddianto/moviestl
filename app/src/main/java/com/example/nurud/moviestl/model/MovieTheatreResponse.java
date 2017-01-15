package com.example.nurud.moviestl.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nurud on 07/01/2017.
 */

public class MovieTheatreResponse {
    @SerializedName("status")
    private String mStatus;
    @SerializedName("kota")
    private String mCity;
    @SerializedName("date")
    private String mDate;
    @SerializedName("data")
    private List<MovieTheatre> mMovieTheatre;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String mCity) {
        this.mCity = mCity;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public List<MovieTheatre> getMovieTheatre() {
        return mMovieTheatre;
    }

    public void setMovieTheatre(List<MovieTheatre> movieTheatres) {
        this.mMovieTheatre = movieTheatres;
    }
}
