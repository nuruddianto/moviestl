package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by nurud on 07/01/2017.
 */
public class MovieTheatre implements Parcelable{
    private String mMovie;
    private String mPoster;
    private String mGenre;
    private String mDuration;
    private List<ShowTimeTheatre> mShowTime;

    public MovieTheatre(Parcel parcel) {
        mMovie = parcel.readString();
        mPoster = parcel.readString();
        mGenre = parcel.readString();
        mDuration = parcel.readString();
        mShowTime = parcel.readArrayList(ShowTimeTheatre.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeString(mMovie);
        destination.writeString(mPoster);
        destination.writeString(mGenre);
        destination.writeString(mDuration);
        destination.writeList(mShowTime);
    }

    public String getMovie() {
        return mMovie;
    }

    public void setMovie(String mMovie) {
        this.mMovie = mMovie;
    }

    public String getPoster() {
        return mPoster;
    }

    public void setPoster(String mPoster) {
        this.mPoster = mPoster;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String mDuration) {
        this.mDuration = mDuration;
    }

    public List<ShowTimeTheatre> getShowTime() {
        return mShowTime;
    }

    public void setShowTime(List<ShowTimeTheatre> mShowTime) {
        this.mShowTime = mShowTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieTheatre> CREATOR = new Creator<MovieTheatre>() {
        @Override
        public MovieTheatre createFromParcel(Parcel parcel) {
            return new MovieTheatre(parcel);
        }

        @Override
        public MovieTheatre[] newArray(int i) {
            return new MovieTheatre[i];
        }
    };
}
