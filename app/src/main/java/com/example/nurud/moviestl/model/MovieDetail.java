package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SRIN on 12/29/2016.
 */
public class MovieDetail implements Parcelable {
    @SerializedName("adult")
    private boolean mAdult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    private List<BelongsToCollection> mBelongsToCollection;
    @SerializedName("budget")
    private int mBudget;
    @SerializedName("genres")
    private List<Genre> mGenres;
    @SerializedName("homepage")
    private String mHomePage;
    @SerializedName("id")
    private int mMovieId;
    @SerializedName("imdb_id")
    private String mImdbId;
    @SerializedName("original_language")
    private String mOriginalLanguage;
    @SerializedName("original_title")
    private String mOriginalTitle;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("popularity")
    private String mPopularity;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("production_companies")
    private List<ProductionCompanies> mProductionCompanies;
    @SerializedName("production_countries")
    private List<ProductionCountries> mProductionCountries;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("revenue")
    private int mRevenue;
    @SerializedName("runtime")
    private int mRunTime;
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> mSpokenLanguage;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("tagline")
    private String mTagLine;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("video")
    private boolean mVideo;
    @SerializedName("vote_average")
    private double mVoteAverage;
    @SerializedName("vote_count")
    private int mVoteCount;

    @Override
    public void writeToParcel(Parcel destination, int i) {

    }

    public MovieDetail(Parcel parcel) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieDetail> CREATOR = new Creator<MovieDetail>() {
        @Override
        public MovieDetail createFromParcel(Parcel parcel) {
            return new MovieDetail(parcel);
        }

        @Override
        public MovieDetail[] newArray(int i) {
            return new MovieDetail[i];
        }
    };
}
