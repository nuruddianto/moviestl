package com.example.nurud.moviestl.rest;

import com.example.nurud.moviestl.model.CityTheatreResponse;
import com.example.nurud.moviestl.model.MovieDetail;
import com.example.nurud.moviestl.model.MovieResponse;
import com.example.nurud.moviestl.model.MovieVideoResponse;
import com.example.nurud.moviestl.model.ReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by nurud on 18/12/2016.
 */

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieDetail> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<MovieResponse> getUpcominMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<MovieVideoResponse> getMovieVideo(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}/reviews")
    Call<ReviewResponse> getMovieReviews(@Path("id") int id, @Query("api_key") String apiKey);

    /*Ibacor*/
    @GET("api/jadwal-bioskop")
    Call<CityTheatreResponse> getCitiesTheatre(@Query("k") String apiKey);

    @GET("api/jadwal-bioskop")
    Call<MovieVideoResponse> getMoviesTheatre(@Query("k") String apiKey, @Query("id") String movieId);
}
