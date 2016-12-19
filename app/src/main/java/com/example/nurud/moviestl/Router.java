package com.example.nurud.moviestl;

import android.app.Activity;
import android.content.Intent;

import com.example.nurud.moviestl.activity.MovieDetailActivity;
import com.example.nurud.moviestl.model.Movie;

/**
 * Created by SRIN on 12/19/2016.
 */
public class Router {

    public static void goToMovieDetail(Activity activity, Movie movie){
        Intent intent = new Intent(activity, MovieDetailActivity.class);
        activity.startActivity(intent);
    }
}
