package com.example.nurud.moviestl.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.activity.MovieDetailActivity;
import com.example.nurud.moviestl.adapter.ReviewAdapter;
import com.example.nurud.moviestl.adapter.TopRatedAdapter;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.Review;
import com.example.nurud.moviestl.model.ReviewResponse;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;
import com.example.nurud.moviestl.rest.RestConstant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends Fragment {

    private static final String TAG = ReviewFragment.class.getSimpleName();
    private ReviewAdapter mReviewAdapter;
    private Activity mActivity;
    private Movie mCurrentMovie;

    public ReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = mActivity.getIntent();
        if (intent != null) {
            mCurrentMovie = intent.getParcelableExtra(MovieDetailActivity.BUNDLE_MOVIE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container,
                savedInstanceState);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView reviewRecycler = (RecyclerView)view.findViewById(R.id.review_recycler);
        reviewRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        ApiInterface apiInterface = BaseApiClient.getClient().create(ApiInterface.class);
        Call<ReviewResponse> call = apiInterface.getMovieReviews(mCurrentMovie.getId() ,RestConstant.TMDB_API_KEY);
        call.enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                List<Review> reviews = response.body().getReview();
                mReviewAdapter = new ReviewAdapter(reviews, R.layout.item_review_movie, getContext());
                reviewRecycler.setAdapter(mReviewAdapter);
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
