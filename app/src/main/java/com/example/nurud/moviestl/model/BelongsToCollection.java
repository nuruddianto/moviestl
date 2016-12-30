package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SRIN on 12/29/2016.
 */
public class BelongsToCollection implements Parcelable {
    @SerializedName("id")
    private int mCollectionId;
    @SerializedName("name")
    private String mCollectionName;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("backdrop_path")
    private String mBackdropPath;

    public BelongsToCollection(Parcel parcel) {
        mCollectionId = parcel.readInt();
        mCollectionName = parcel.readString();
        mPosterPath = parcel.readString();
        mBackdropPath = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeInt(mCollectionId);
        destination.writeString(mCollectionName);
        destination.writeString(mPosterPath);
        destination.writeString(mBackdropPath);
    }

    public int getCollectionId() {
        return mCollectionId;
    }

    public void setCollectionId(int mCollectionId) {
        this.mCollectionId = mCollectionId;
    }

    public String getCollectionName() {
        return mCollectionName;
    }

    public void setCollectionName(String mCollectionName) {
        this.mCollectionName = mCollectionName;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String mBackdropPath) {
        this.mBackdropPath = mBackdropPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BelongsToCollection> CREATOR = new Creator<BelongsToCollection>() {
        @Override
        public BelongsToCollection createFromParcel(Parcel parcel) {
            return new BelongsToCollection(parcel);
        }

        @Override
        public BelongsToCollection[] newArray(int i) {
            return new BelongsToCollection[i];
        }
    };
}
