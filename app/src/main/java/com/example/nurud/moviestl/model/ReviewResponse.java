package com.example.nurud.moviestl.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SRIN on 12/30/2016.
 */
public class ReviewResponse {
    @SerializedName("id")
    private String mReviewResponseId;
    @SerializedName("page")
    private int mReviewPage;
    @SerializedName("results")
    private List<Review> mReview;
    @SerializedName("total_pages")
    private int mTotalPages;
    @SerializedName("total_results")
    private int mTotalResults;

    public String getReviewId() {
        return mReviewResponseId;
    }

    public void setReviewId(String mReviewId) {
        this.mReviewResponseId = mReviewId;
    }

    public int getReviewPage() {
        return mReviewPage;
    }

    public void setReviewPage(int mReviewPage) {
        this.mReviewPage = mReviewPage;
    }

    public List<Review> getReview() {
        return mReview;
    }

    public void setmReview(List<Review> mReview) {
        this.mReview = mReview;
    }

    public int getmTotalPages() {
        return mTotalPages;
    }

    public void setmTotalPages(int mTotalPages) {
        this.mTotalPages = mTotalPages;
    }

    public int getmTotalResults() {
        return mTotalResults;
    }

    public void setmTotalResults(int mTotalResults) {
        this.mTotalResults = mTotalResults;
    }
}
