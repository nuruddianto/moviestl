package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nurud on 07/01/2017.
 */
public class CityTheatre implements Parcelable {
    @SerializedName("id")
    private String mId;
    @SerializedName("kota")
    private String mCity;

    public CityTheatre(Parcel parcel) {
        mId = parcel.readString();
        mCity = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeString(mId);
        destination.writeString(mCity);
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        this.mCity = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CityTheatre> CREATOR = new Creator<CityTheatre>() {
        @Override
        public CityTheatre createFromParcel(Parcel parcel) {
            return new CityTheatre(parcel);
        }

        @Override
        public CityTheatre[] newArray(int i) {
            return new CityTheatre[i];
        }
    };
}
