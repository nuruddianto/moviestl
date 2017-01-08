package com.example.nurud.moviestl.model;

import java.util.List;

/**
 * Created by nurud on 07/01/2017.
 */

public class MovieTheatreResponse {
    private String mStatus;
    private String mMessage;
    private String mCity;
    private String mDate;
    private List<MovieTheatre> mMovieTheatre;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
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

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public List<MovieTheatre> getMovieTheatre() {
        return mMovieTheatre;
    }

    public void setMovieTheatre(List<MovieTheatre> mMovieTheatre) {
        this.mMovieTheatre = mMovieTheatre;
    }
}
