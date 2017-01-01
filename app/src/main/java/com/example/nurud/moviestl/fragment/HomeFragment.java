package com.example.nurud.moviestl.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.PosterTypeAdapter;
import com.example.nurud.moviestl.adapter.TopRatedAdapter;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.MovieResponse;
import com.example.nurud.moviestl.model.PosterType;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;
import com.example.nurud.moviestl.rest.RestConstant;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @InjectView(R.id.list_poster_type)
    ExpandableListView mPosterListView;

    private List<PosterType> mPosterTypes = new ArrayList<>();
    private ExpandableListAdapter mPosterTypeAdapter;

    private static final String TAG = HomeFragment.class.getSimpleName();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        setData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    private void setData(){
        ApiInterface apiInterface = BaseApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiInterface.getTopRatedMovies(RestConstant.TMDB_API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> topRated = response.body().getResults();
                PosterType topRate = new PosterType("Top Rated", topRated);
                mPosterTypes.add(topRate);

                mPosterTypeAdapter = new PosterTypeAdapter(getContext(), mPosterTypes);
                mPosterListView.setAdapter(mPosterTypeAdapter);
                mPosterListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                    int previousGroup = -1;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if ((previousGroup != -1) && (groupPosition != previousGroup)) {
                            mPosterListView.collapseGroup(previousGroup);
                        }
                        previousGroup = groupPosition;
                    }
                });

                Log.d(TAG, "Jumlah movie yang didapat:" + topRated.size());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
                Toast.makeText(getContext(), "Fail to get top rated movie", Toast.LENGTH_LONG);
            }


        });

    }
}
