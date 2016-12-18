package com.example.nurud.moviestl.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.MoviesAdapter;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.MovieResponse;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    private static final String TAG = DashboardActivity.class.getSimpleName();
    private final static String API_KEY = "57eb0744e12fae2247350bc2bc8b2cc5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movie_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = BaseApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiInterface.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.item_movie, getApplicationContext()));
                Log.d(TAG, "Jumlah movie yang didapat:"+ movies.size());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
