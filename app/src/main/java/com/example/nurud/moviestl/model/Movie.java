package com.example.nurud.moviestl.model;

/**
 * Created by nurud on 18/12/2016.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {

    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("title")
    private String title;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<>();
    @SerializedName("id")
    private int id;
    @SerializedName("release_date")
    private String releasDate;
    @SerializedName("overview")
    private String overview;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("poster_path")
    private String posterPath;

    public Movie() {

    }

    public Movie(Parcel parcel) {
        voteAverage = parcel.readDouble();
        video = parcel.readByte() != 0;
        voteCount = parcel.readInt();
        popularity = parcel.readDouble();
        backdropPath = parcel.readString();
        title = parcel.readString();
        originalLanguage = parcel.readString();
        originalTitle = parcel.readString();
        genreIds = parcel.readArrayList(Integer.class.getClassLoader());
        id = parcel.readInt();
        releasDate = parcel.readString();
        overview = parcel.readString();
        adult = parcel.readByte() != 0;
        posterPath = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(voteAverage);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeInt(voteCount);
        dest.writeDouble(popularity);
        dest.writeString(backdropPath);
        dest.writeString(title);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeList(genreIds);
        dest.writeInt(id);
        dest.writeString(releasDate);
        dest.writeString(overview);
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(posterPath);
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReleasDate() {
        return releasDate;
    }

    public void setReleasDate(String releasDate) {
        this.releasDate = releasDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int i) {
            return new Movie[i];
        }
    };

}
