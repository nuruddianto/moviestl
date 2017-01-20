package com.example.nurud.moviestl;

import android.app.Activity;
import android.content.Intent;

import com.example.nurud.moviestl.activity.MovieDetailActivity;
import com.example.nurud.moviestl.activity.MovieTheatreActivity;
import com.example.nurud.moviestl.activity.ShowTimeTheatreActivity;
import com.example.nurud.moviestl.activity.TwentyOneActivity;
import com.example.nurud.moviestl.model.CityTheatre;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.MovieTheatre;

/**
 * Created by SRIN on 12/19/2016.
 */
public class Router {

    public static void goToMovieDetail(Activity activity, Movie movie) {
        Intent intent = new Intent(activity, MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.BUNDLE_MOVIE, movie);
        activity.startActivity(intent);
    }

    public static void goToMovieTheatre(Activity activity, CityTheatre cityTheatre){
        Intent intent = new Intent(activity, MovieTheatreActivity.class);
        intent.putExtra(MovieTheatreActivity.BUNDLE_CITY_THEATRE, cityTheatre);
        activity.startActivity(intent);
    }

    public static void goToShowTimeTheatre(Activity activity, MovieTheatre movieTheatre, String movieDate){
        Intent intent = new Intent(activity, ShowTimeTheatreActivity.class);
        intent.putExtra(ShowTimeTheatreActivity.BUNDLE_SHOW_TIME_THEATRE, movieTheatre);
        intent.putExtra(ShowTimeTheatreActivity.BUNDLE_MOVIE_DATE_THEATRE, movieDate);
        activity.startActivity(intent);
    }

    public static void goToTwentyOne(Activity activity){
        Intent intent = new Intent(activity, TwentyOneActivity.class);
        activity.startActivity(intent);
    }
}
