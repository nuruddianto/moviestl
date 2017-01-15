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

    public void setReviewId(String reviewId) {
        this.mReviewResponseId = reviewId;
    }

    public int getReviewPage() {
        return mReviewPage;
    }

    public void setReviewPage(int reviewPage) {
        this.mReviewPage = reviewPage;
    }

    public List<Review> getReview() {
        return mReview;
    }

    public void setmReview(List<Review> reviews) {
        this.mReview = reviews;
    }

    public int getmTotalPages() {
        return mTotalPages;
    }

    public void setmTotalPages(int totalPages) {
        this.mTotalPages = totalPages;
    }

    public int getmTotalResults() {
        return mTotalResults;
    }

    public void setmTotalResults(int totalResults) {
        this.mTotalResults = totalResults;
    }
}
