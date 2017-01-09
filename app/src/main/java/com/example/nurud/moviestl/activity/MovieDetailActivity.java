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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.MovieDetailViewPagerAdapter;
import com.example.nurud.moviestl.model.Genre;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.MovieDetail;
import com.example.nurud.moviestl.model.MovieVideo;
import com.example.nurud.moviestl.model.MovieVideoResponse;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;
import com.example.nurud.moviestl.rest.RestConstant;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String TAG = MovieDetailActivity.class.getSimpleName();

    private ActionBar mActionBar;
    private Movie mCurrentMovie;
    private MovieDetail mMovieDetail;
    private ApiInterface mApiInterface;
    private Intent mIntent;
    private List<MovieVideo> mTrailer;

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
    @InjectView(R.id.movie_detail_title)
    protected TextView mTitle;
    @InjectView(R.id.movie_detail_genres)
    protected TextView mGenres;

    public static final String BUNDLE_MOVIE = "BUNDLE_MOVIE";
    public static final String BUNDLE_MOVIE_DETAIL = "BUNDLE_MOVIE_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.inject(this);
        mIntent = getIntent();
        if (mIntent != null) {
            mCurrentMovie = mIntent.getParcelableExtra(BUNDLE_MOVIE);
        }
        mApiInterface = BaseApiClient.getClient().create(ApiInterface.class);
        getMovieDetail();
    }

    private void setViewPagerAdapter(){
        MovieDetailViewPagerAdapter adapter = new MovieDetailViewPagerAdapter(getSupportFragmentManager(), this);
        mMovieDetailViewPager.setAdapter(adapter);
        mMovieDetailTabLayout.setupWithViewPager(mMovieDetailViewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.inject(this);
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
        Picasso.with(this).load(Uri.parse(String.format(getString(R.string.image_url), mCurrentMovie.getBackdropPath())))
                .placeholder(defaultImageDrawable)
                .noFade()
                .fit()
                .into(mBackDrop);

        Picasso.with(this).load(Uri.parse(String.format(getString(R.string.image_url),mCurrentMovie.getPosterPath())))
                .noFade()
                .fit()
                .into(mPoster);
        mTitle.setText(mMovieDetail.getTitle());
        List<Genre> genres = mMovieDetail.getGenres();
        String genre = "";
        for(int i =0; i < genres.size(); i++){
            genre += genres.get(i).getGenreName();
            if(i != genres.size()-1){
                genre += ", ";
            }
        }
        mGenres.setText(genre);
        mPlayTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoUrl = "";
                videoUrl = String.format(getString(R.string.youtube_url), mTrailer.get(mTrailer.size() - 1).getVideoKey());
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)));
            }
        });
    }

    private void getMovieDetail(){
        Call<MovieDetail> call = mApiInterface.getMovieDetails(mCurrentMovie.getId(), RestConstant.TMDB_API_KEY);
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                mMovieDetail = response.body();
                mIntent.putExtra(MovieDetailActivity.BUNDLE_MOVIE_DETAIL, mMovieDetail);
                Log.d(TAG, String.format(getString(R.string.log_success_hit_movie_detail), mMovieDetail.getTitle()));
                getMovieTrailer();
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void getMovieTrailer(){
        Call<MovieVideoResponse> call = mApiInterface.getMovieVideo(mCurrentMovie.getId(), RestConstant.TMDB_API_KEY);
        call.enqueue(new Callback<MovieVideoResponse>() {
            @Override
            public void onResponse(Call<MovieVideoResponse> call, Response<MovieVideoResponse> response) {
                mTrailer = response.body().getResults();
                setViewPagerAdapter();
                initializeMovieDetailHeader();
            }

            @Override
            public void onFailure(Call<MovieVideoResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

}
