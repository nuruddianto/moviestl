package com.example.nurud.moviestl.model;

/**
 * Created by nurud on 18/12/2016.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {

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
    private String originaltitle;
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

    public Movie(double voteAverage, boolean video, int voteCount, double popularity, String backdropPath, String title, String originalLanguage, String originaltitle, List<Integer> genreIds, int id, String releasDate, String overview, boolean adult, String posterPath) {
        this.voteAverage = voteAverage;
        this.video = video;
        this.voteCount = voteCount;
        this.popularity = popularity;
        this.backdropPath = backdropPath;
        this.title = title;
        this.originalLanguage = originalLanguage;
        this.originaltitle = originaltitle;
        this.genreIds = genreIds;
        this.id = id;
        this.releasDate = releasDate;
        this.overview = overview;
        this.adult = adult;
        this.posterPath = posterPath;
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

    public String getOriginaltitle() {
        return originaltitle;
    }

    public void setOriginaltitle(String originaltitle) {
        this.originaltitle = originaltitle;
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
}
