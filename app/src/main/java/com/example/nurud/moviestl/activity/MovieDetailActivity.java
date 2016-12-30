package com.example.nurud.moviestl.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.MovieDetailViewPagerAdapter;
import com.example.nurud.moviestl.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MovieDetailActivity extends AppCompatActivity {
    private ActionBar mActionBar;
    private Movie mCurrentMovie;

    @InjectView(R.id.toolbar)
    protected Toolbar mToolbar;
    @InjectView(R.id.movie_detail_tabs)
    protected TabLayout mMovieDetailTabLayout;
    @InjectView(R.id.movie_detail_view_pager)
    protected ViewPager mMovieDetailViewPager;

    /*Movie Detail Header View*/
    @InjectView(R.id.backdrop_movie_detail)
    protected ImageView mBackDrop;
    @InjectView(R.id.poster_movie_detail)
    protected ImageView mPoster;
    @InjectView(R.id.floating_play_trailer_button)
    protected FloatingActionButton mPlayTrailer;
    @InjectView(R.id.movie_detail_rating)
    protected TextView mRating;
    @InjectView(R.id.movie_detail_total_vote)
    protected TextView mTotalVote;

    public static final String BUNDLE_MOVIE = "BUNDLE_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        if (intent != null) {
            mCurrentMovie = intent.getParcelableExtra(BUNDLE_MOVIE);
        }

        MovieDetailViewPagerAdapter adapter = new MovieDetailViewPagerAdapter(getSupportFragmentManager(), this);
        mMovieDetailViewPager.setAdapter(adapter);
        mMovieDetailTabLayout.setupWithViewPager(mMovieDetailViewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeMovieDetailHeader();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
        if (mToolbar != null) {
            mToolbar.setTitle(getString(R.string.movie_detail));
            mToolbar.setTitleTextColor(Color.BLACK);
            setSupportActionBar(mToolbar);
        }
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeMovieDetailHeader() {
        if (mCurrentMovie == null) {
            return;
        }
        int defaultImageDrawable = R.drawable.icon_app_movie_ciano;
        Picasso.with(this).load(Uri.parse("http://image.tmdb.org/t/p/w500" + mCurrentMovie.getBackdropPath()))
                .placeholder(defaultImageDrawable)
                .noFade()
                .fit()
                .into(mBackDrop);

        Picasso.with(this).load(Uri.parse("http://image.tmdb.org/t/p/w500" + mCurrentMovie.getPosterPath()))
                .noFade()
                .fit()
                .into(mPoster);
        mRating.setText(String.valueOf(mCurrentMovie.getVoteAverage()));
        mTotalVote.setText(String.valueOf(mCurrentMovie.getVoteCount()));
    }
}
