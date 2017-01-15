package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nurud on 07/01/2017.
 */
public class MovieTheatre implements Parcelable{
    @SerializedName("movie")
    private String mMovie;
    @SerializedName("poster")
    private String mPoster;
    @SerializedName("genre")
    private String mGenre;
    @SerializedName("duration")
    private String mDuration;
    @SerializedName("jadwal")
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

    public void setMovie(String movie) {
        this.mMovie = movie;
    }

    public String getPoster() {
        return mPoster;
    }

    public void setPoster(String poster) {
        this.mPoster = poster;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        this.mGenre = genre;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        this.mDuration = duration;
    }

    public List<ShowTimeTheatre> getShowTime() {
        return mShowTime;
    }

    public void setShowTime(List<ShowTimeTheatre> showTime) {
        this.mShowTime = showTime;
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
