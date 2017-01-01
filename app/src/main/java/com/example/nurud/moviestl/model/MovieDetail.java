package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRIN on 12/29/2016.
 */
public class MovieDetail implements Parcelable {
    @SerializedName("adult")
    private boolean mAdult;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("belongs_to_collection")
    private BelongsToCollection mBelongsToCollection;
    @SerializedName("budget")
    private int mBudget;
    @SerializedName("genres")
    private List<Genre> mGenres = new ArrayList<>();
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
    private Double mPopularity;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("production_companies")
    private List<ProductionCompanies> mProductionCompanies = new ArrayList<>();
    @SerializedName("production_countries")
    private List<ProductionCountries> mProductionCountries = new ArrayList<>();
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("revenue")
    private int mRevenue;
    @SerializedName("runtime")
    private int mRunTime;
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> mSpokenLanguage = new ArrayList<>();
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

    public MovieDetail(Parcel parcel) {
        mAdult =  parcel.readByte() != 0;
        mBackdropPath = parcel.readString();
        mBelongsToCollection = parcel.readParcelable(BelongsToCollection.class.getClassLoader());
        mBudget = parcel.readInt();
        mGenres = parcel.readArrayList(Genre.class.getClassLoader());
        mHomePage = parcel.readString();
        mMovieId = parcel.readInt();
        mImdbId = parcel.readString();
        mOriginalLanguage = parcel.readString();
        mOriginalTitle = parcel.readString();
        mOverview = parcel.readString();
        mPopularity = parcel.readDouble();
        mPosterPath = parcel.readString();
        mProductionCompanies = parcel.readArrayList(ProductionCompanies.class.getClassLoader());
        mProductionCountries = parcel.readArrayList(ProductionCountries.class.getClassLoader());
        mReleaseDate = parcel.readString();
        mRevenue = parcel.readInt();
        mRunTime = parcel.readInt();
        mSpokenLanguage = parcel.readArrayList(SpokenLanguage.class.getClassLoader());
        mStatus = parcel.readString();
        mTagLine = parcel.readString();
        mTitle = parcel.readString();
        mVideo = parcel.readByte() !=0;
        mVoteAverage = parcel.readDouble();
        mVoteCount = parcel.readInt();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeByte((byte) (mAdult ? 1 : 0));
        destination.writeString(mBackdropPath);
        destination.writeParcelable(mBelongsToCollection, i);
        destination.writeInt(mBudget);
        destination.writeList(mGenres);
        destination.writeString(mHomePage);
        destination.writeInt(mMovieId);
        destination.writeString(mImdbId);
        destination.writeString(mOriginalLanguage);
        destination.writeString(mOriginalTitle);
        destination.writeString(mOverview);
        destination.writeDouble(mPopularity);
        destination.writeString(mPosterPath);
        destination.writeList(mProductionCompanies);
        destination.writeList(mProductionCountries);
        destination.writeString(mReleaseDate);
        destination.writeInt(mRevenue);
        destination.writeInt(mRunTime);
        destination.writeList(mSpokenLanguage);
        destination.writeString(mStatus);
        destination.writeString(mTagLine);
        destination.writeString(mTitle);
        destination.writeByte((byte)(mVideo ? 1 : 0));
        destination.writeDouble(mVoteAverage);
        destination.writeInt(mVoteCount);
    }

    public boolean isAdult() {
        return mAdult;
    }

    public void setAdult(boolean mAdult) {
        this.mAdult = mAdult;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String mBackdropPath) {
        this.mBackdropPath = mBackdropPath;
    }

    public BelongsToCollection getBelongsToCollection() {
        return mBelongsToCollection;
    }

    public void setBelongsToCollection(BelongsToCollection mBelongsToCollection) {
        this.mBelongsToCollection = mBelongsToCollection;
    }

    public int getBudget() {
        return mBudget;
    }

    public void setBudget(int mBudget) {
        this.mBudget = mBudget;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> mGenres) {
        this.mGenres = mGenres;
    }

    public String getHomePage() {
        return mHomePage;
    }

    public void setHomePage(String mHomePage) {
        this.mHomePage = mHomePage;
    }

    public int getMovieId() {
        return mMovieId;
    }

    public void setMovieId(int mMovieId) {
        this.mMovieId = mMovieId;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public void setImdbId(String mImdbId) {
        this.mImdbId = mImdbId;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setOriginalLanguage(String mOriginalLanguage) {
        this.mOriginalLanguage = mOriginalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String mOriginalTitle) {
        this.mOriginalTitle = mOriginalTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public Double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(Double mPopularity) {
        this.mPopularity = mPopularity;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }

    public List<ProductionCompanies> getProductionCompanies() {
        return mProductionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompanies> mProductionCompanies) {
        this.mProductionCompanies = mProductionCompanies;
    }

    public List<ProductionCountries> getProductionCountries() {
        return mProductionCountries;
    }

    public void setProductionCountries(List<ProductionCountries> mProductionCountries) {
        this.mProductionCountries = mProductionCountries;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public int getRevenue() {
        return mRevenue;
    }

    public void setRevenue(int mRevenue) {
        this.mRevenue = mRevenue;
    }

    public int getRunTime() {
        return mRunTime;
    }

    public void setRunTime(int mRunTime) {
        this.mRunTime = mRunTime;
    }

    public List<SpokenLanguage> getSpokenLanguage() {
        return mSpokenLanguage;
    }

    public void setSpokenLanguage(List<SpokenLanguage> mSpokenLanguage) {
        this.mSpokenLanguage = mSpokenLanguage;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getTagLine() {
        return mTagLine;
    }

    public void setTagLine(String mTagLine) {
        this.mTagLine = mTagLine;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean isVideo() {
        return mVideo;
    }

    public void setVideo(boolean mVideo) {
        this.mVideo = mVideo;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(double mVoteAverage) {
        this.mVoteAverage = mVoteAverage;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(int mVoteCount) {
        this.mVoteCount = mVoteCount;
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
