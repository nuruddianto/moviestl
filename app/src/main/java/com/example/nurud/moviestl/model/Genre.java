package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nurud on 12/29/2016.
 */
public class Genre implements Parcelable {
    @SerializedName("id")
    private int mGenreId;
    @SerializedName("name")
    private String mGenreName;

    public Genre(Parcel parcel) {
        mGenreId = parcel.readInt();
        mGenreName = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeInt(mGenreId);
        destination.writeString(mGenreName);
    }

    public int getGenreId() {
        return mGenreId;
    }

    public void setGenreId(int genreId) {
        this.mGenreId = genreId;
    }

    public String getGenreName() {
        return mGenreName;
    }

    public void setGenreName(String genreName) {
        this.mGenreName = genreName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel parcel) {
            return new Genre(parcel);
        }

        @Override
        public Genre[] newArray(int i) {
            return new Genre[i];
        }
    };
}
