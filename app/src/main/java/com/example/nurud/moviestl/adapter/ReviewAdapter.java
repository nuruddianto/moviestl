package com.example.nurud.moviestl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.model.Review;

import java.util.List;

/**
 * Created by SRIN on 1/3/2017.
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    private List<Review> mReview;
    private int mRowLayout;
    private Context mContext;

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        View mReviewCard;
        TextView mReviewContent;
        TextView mReviewAuthor;

        public ReviewViewHolder(View v) {
            super(v);
            mReviewCard = v.findViewById(R.id.review_card_view);
            mReviewContent = (TextView) v.findViewById(R.id.review_content);
            mReviewAuthor = (TextView) v.findViewById(R.id.review_author);
        }
    }

    public ReviewAdapter(List<Review> mReview, int mRowLayout, Context mContext) {
        this.mReview = mReview;
        this.mRowLayout = mRowLayout;
        this.mContext = mContext;
    }

    @Override
    public ReviewAdapter.ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayout, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewAdapter.ReviewViewHolder holder, int position) {
        holder.mReviewAuthor.setText(mReview.get(position).getAuthor());
        holder.mReviewContent.setText(mReview.get(position).getReviewContent());
    }

    @Override
    public int getItemCount() {
        return mReview.size();
    }


}
