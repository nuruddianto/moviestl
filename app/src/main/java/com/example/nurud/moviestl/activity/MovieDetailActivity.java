package com.example.nurud.moviestl.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nurud.moviestl.R;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String BUNDLE_MOVIE_DETAIL = "BUNDLE_MOVIE_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }
}
