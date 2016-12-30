package com.example.nurud.moviestl.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SRIN on 12/30/2016.
 */
public class Review implements Parcelable {
    @SerializedName("id")
    private String mReviewId;
    @SerializedName("author")
    private String mAuthor;
    @SerializedName("content")
    private String mReviewContent;
    @SerializedName("url")
    private String mUrl;

    public Review(Parcel parcel) {
        mReviewId = parcel.readString();
        mAuthor = parcel.readString();
        mReviewContent = parcel.readString();
        mUrl = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel destination, int i) {
        destination.writeString(mReviewId);
        destination.writeString(mAuthor);
        destination.writeString(mReviewContent);
        destination.writeString(mUrl);
    }

    public String getReviewId() {
        return mReviewId;
    }

    public void setReviewId(String mReviewId) {
        this.mReviewId = mReviewId;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getReviewContent() {
        return mReviewContent;
    }

    public void setReviewContent(String mContent) {
        this.mReviewContent = mContent;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel parcel) {
            return new Review(parcel);
        }

        @Override
        public Review[] newArray(int i) {
            return new Review[i];
        }
    };
}
