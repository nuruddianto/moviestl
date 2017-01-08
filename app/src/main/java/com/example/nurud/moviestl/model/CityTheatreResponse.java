package com.example.nurud.moviestl.model;

import java.util.List;

/**
 * Created by nurud on 07/01/2017.
 */

public class CityTheatreResponse {
    private String mStatus;
    private String mMessage;
    private List<CityTheatre> mCitiesTheatre;

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

    public List<CityTheatre> getCitiesTheatre() {
        return mCitiesTheatre;
    }

    public void setCitiesTheatre(List<CityTheatre> mCitiesTheatre) {
        this.mCitiesTheatre = mCitiesTheatre;
    }
}
