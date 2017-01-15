package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by nurud on 12/27/16.
 */
public class Showtime implements Parcelable {

    private String mTheatre;
    private List<String> mHour;
    private String mPrice;

    public Showtime() {
    }

    protected Showtime(Parcel in) {
        this.mTheatre = in.readString();
        this.mHour = in.createStringArrayList();
        this.mPrice = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTheatre);
        dest.writeStringList(this.mHour);
        dest.writeString(this.mPrice);
    }

    public String getTheatre() {
        return mTheatre;
    }

    public void setTheatre(String theatre) {
        this.mTheatre = theatre;
    }

    public List<String> getHour() {
        return mHour;
    }

    public void setHour(List<String> hour) {
        this.mHour = hour;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        this.mPrice = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Showtime> CREATOR = new Parcelable.Creator<Showtime>() {
        @Override
        public Showtime createFromParcel(Parcel source) {
            return new Showtime(source);
        }

        @Override
        public Showtime[] newArray(int size) {
            return new Showtime[size];
        }
    };
}
