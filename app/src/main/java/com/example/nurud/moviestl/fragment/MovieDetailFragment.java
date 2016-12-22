package com.example.nurud.moviestl.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.activity.MovieDetailActivity;
import com.example.nurud.moviestl.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {

    @InjectView(R.id.img_movie_2x1)
    protected ImageView mImageMovie;
    @InjectView(R.id.movie_title)
    TextView mMovieTitle;
    @InjectView(R.id.movie_description)
    WebView mMovieDescription;
    @InjectView(R.id.movie_detail_rating)
    TextView mRating;
    @InjectView(R.id.movie_detail_vote_count)
    TextView mVoteCount;

    private Activity mActivity;
    private Movie mCurrentMovie;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = mActivity.getIntent();
        if (intent != null) {
            mCurrentMovie = intent.getParcelableExtra(MovieDetailActivity.BUNDLE_MOVIE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        setView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    private void setView() {
        if (mCurrentMovie == null) {
            return;
        }
        int defaultImageDrawable = R.drawable.img_promo_banner_2x1_default;
        Picasso.with(mActivity).load(Uri.parse("http://image.tmdb.org/t/p/w500" + mCurrentMovie.getBackdropPath()))
                .placeholder(defaultImageDrawable)
                .noFade()
                .fit()
                .into(mImageMovie);
        mMovieTitle.setText(mCurrentMovie.getTitle());
        //Set up description webview
        String desc = "<html><body><p align=\"justify\">";
        desc += mCurrentMovie.getOverview();
        desc += "</p></body></html>";
        mMovieDescription.loadData(desc, "text/html", "utf-8");
        mRating.setText(String.valueOf(mCurrentMovie.getVoteAverage()));
        mVoteCount.setText(String.valueOf(mCurrentMovie.getVoteCount()));
    }
}
