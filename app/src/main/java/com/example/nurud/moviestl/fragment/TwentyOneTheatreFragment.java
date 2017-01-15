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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.CityTheatreAdapter;
import com.example.nurud.moviestl.model.CityTheatre;
import com.example.nurud.moviestl.model.CityTheatreResponse;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;
import com.example.nurud.moviestl.rest.RestConstant;

import java.net.SocketTimeoutException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwentyOneTheatreFragment extends Fragment {
    private static final String TAG = TwentyOneTheatreFragment.class.getSimpleName();
    private CityTheatreAdapter mCityTheatreAdapter;

    @InjectView(R.id.city_theatre_recycler)
    RecyclerView mTheatreRecycler;

    public TwentyOneTheatreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container,
                savedInstanceState);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_twenty_one_theatre, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        
        mTheatreRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        ApiInterface apiInterface = BaseApiClient.getIbacorClient().create(ApiInterface.class);
        Call<CityTheatreResponse> call = apiInterface.getCitiesTheatre(RestConstant.IBACOR_API_KEY);
        call.enqueue(new Callback<CityTheatreResponse>() {
            @Override
            public void onResponse(Call<CityTheatreResponse> call, Response<CityTheatreResponse> response) {
                List<CityTheatre> citiesTheatre = response.body().getCitieTheatres();
                mCityTheatreAdapter = new CityTheatreAdapter(citiesTheatre, R.layout.item_city_theatre, getContext());
                mTheatreRecycler.setAdapter(mCityTheatreAdapter);
                Log.d(TAG, String.format(getString(R.string.log_twenty_one_theatre), citiesTheatre.size()) );
            }

            @Override
            public void onFailure(Call<CityTheatreResponse> call, Throwable t) {
                if(t instanceof SocketTimeoutException) {
                    Toast.makeText(getActivity(), "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "Connection Error!", Toast.LENGTH_LONG).show();
                }
                Log.i("FAILURE", t.toString());
            }
        });
    }
}
