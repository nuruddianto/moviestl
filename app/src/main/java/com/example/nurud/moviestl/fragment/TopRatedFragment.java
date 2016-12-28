package com.example.nurud.moviestl.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.TopRatedAdapter;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.MovieResponse;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;
import com.example.nurud.moviestl.rest.RestConstant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedFragment extends Fragment {

    private static final String TAG = TopRatedFragment.class.getSimpleName();
    private TopRatedAdapter mTopRatedAdapter;

    public TopRatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container,
                savedInstanceState);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_rated, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView mMovieRecycler = (RecyclerView) view.findViewById(R.id.movie_recycler);
        mMovieRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        ApiInterface apiInterface = BaseApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiInterface.getTopRatedMovies(RestConstant.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                mTopRatedAdapter = new TopRatedAdapter(movies, R.layout.item_top_rated_movie, getContext());
                mMovieRecycler.setAdapter(mTopRatedAdapter);
                Log.d(TAG, "Jumlah movie yang didapat:" + movies.size());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
                Toast.makeText(getContext(), "Fail to get top rated movie", Toast.LENGTH_LONG);
            }
        });
    }
}
