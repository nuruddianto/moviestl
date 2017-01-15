package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nurud on 07/01/2017.
 */
public class ShowTimeTheatre implements Parcelable {
    @SerializedName("bioskop")
    private String mTheatre;
    @SerializedName("jam")
    private List<String> mTime;
    @SerializedName("harga")
    private String mPrice;

    public ShowTimeTheatre(Parcel parcel) {
        mTheatre = parcel.readString();
        mTime = parcel.createStringArrayList();
        mPrice = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeString(mTheatre);
        destination.writeStringList(mTime);
        destination.writeString(mPrice);
    }

    public String getTheatre() {
        return mTheatre;
    }

    public void setTheatre(String mTheatre) {
        this.mTheatre = mTheatre;
    }

    public List<String> getTime() {
        return mTime;
    }

    public void setTime(List<String> mTime) {
        this.mTime = mTime;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ShowTimeTheatre> CREATOR = new Creator<ShowTimeTheatre>() {
        @Override
        public ShowTimeTheatre createFromParcel(Parcel parcel) {
            return new ShowTimeTheatre(parcel);
        }

        @Override
        public ShowTimeTheatre[] newArray(int i) {
            return new ShowTimeTheatre[i];
        }
    };
}
