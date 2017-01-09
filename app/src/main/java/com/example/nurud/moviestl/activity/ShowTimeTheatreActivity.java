package com.example.nurud.moviestl.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.ShowTimeTheatreAdapter;
import com.example.nurud.moviestl.model.MovieTheatre;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShowTimeTheatreActivity extends AppCompatActivity {

    public static final String BUNDLE_SHOW_TIME_THEATRE = "BUNDLE_SHOW_TIME_THEATRE";
    public static final String BUNDLE_MOVIE_DATE_THEATRE = "BUNDLE_MOVIE_DATE_THEATRE";

    private MovieTheatre mMovieTheatre;
    private String mMovieDate;

    @InjectView(R.id.showtime_recycler)
    RecyclerView mShowTimeRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        setContentView(R.layout.activity_show_time_theatre);
        Intent intent = getIntent();
        mMovieTheatre = intent.getParcelableExtra(BUNDLE_SHOW_TIME_THEATRE);
        mMovieDate = intent.getStringExtra(BUNDLE_MOVIE_DATE_THEATRE);

        ShowTimeTheatreAdapter adapter = new ShowTimeTheatreAdapter(mMovieTheatre.getShowTime(), R.layout.item_time_theatre, this );
        mShowTimeRecycler.setLayoutManager(new LinearLayoutManager(this));
        mShowTimeRecycler.setAdapter(adapter);
    }
}
