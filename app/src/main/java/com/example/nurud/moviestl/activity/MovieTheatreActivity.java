package com.example.nurud.moviestl.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.MovieTheatreAdapter;
import com.example.nurud.moviestl.model.CityTheatre;
import com.example.nurud.moviestl.model.MovieTheatre;
import com.example.nurud.moviestl.model.MovieTheatreResponse;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;
import com.example.nurud.moviestl.rest.RestConstant;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieTheatreActivity extends AppCompatActivity {

    public static final String BUNDLE_CITY_THEATRE = "BUNDLE_CITY_THEATRE";
    private Intent mIntent;
    private CityTheatre mCityTheatre;
    private MovieTheatreAdapter mMovieTheatreAdapter;

    @InjectView(R.id.movie_theatre_recycler)
    RecyclerView mMovieTheatreRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_theatre);
        ButterKnife.inject(this);
        mIntent = getIntent();
        if(mIntent != null){
            mCityTheatre = mIntent.getParcelableExtra(BUNDLE_CITY_THEATRE);
            getData();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.inject(this);
    }

    protected void getData() {
        ApiInterface apiInterface = BaseApiClient.getIbacorClient().create(ApiInterface.class);
        Call<MovieTheatreResponse> call = apiInterface.getMoviesTheatre(RestConstant.IBACOR_API_KEY, mCityTheatre.getId());
        call.enqueue(new Callback<MovieTheatreResponse>() {
            @Override
            public void onResponse(Call<MovieTheatreResponse> call, Response<MovieTheatreResponse> response) {
                List<MovieTheatre> movieTheatres = response.body().getMovieTheatre();
                String movieDate = response.body().getDate();
                setAdapter(movieTheatres, movieDate);
            }

            @Override
            public void onFailure(Call<MovieTheatreResponse> call, Throwable t) {

            }
        });
    }

    protected void setAdapter(List<MovieTheatre> movieTheatre, String movieDate){
        mMovieTheatreAdapter = new MovieTheatreAdapter(movieTheatre, R.layout.item_movie_theatre,this, movieDate );
        mMovieTheatreRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMovieTheatreRecycler.setAdapter(mMovieTheatreAdapter);
    }
}
