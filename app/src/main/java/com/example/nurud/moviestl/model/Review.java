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

    public void setReviewId(String reviewId) {
        this.mReviewId = reviewId;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public String getReviewContent() {
        return mReviewContent;
    }

    public void setReviewContent(String content) {
        this.mReviewContent = content;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setmUrl(String url) {
        this.mUrl = url;
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
