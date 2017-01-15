package com.example.nurud.moviestl.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nurud on 07/01/2017.
 */

public class CityTheatreResponse {
    @SerializedName("status")
    private String mStatus;
    @SerializedName("data")
    private List<CityTheatre> mCitiesTheatre;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public List<CityTheatre> getCitieTheatres() {
        return mCitiesTheatre;
    }

    public void setCitiesTheatre(List<CityTheatre> cityTheatres) {
        this.mCitiesTheatre = cityTheatres;
    }
}
