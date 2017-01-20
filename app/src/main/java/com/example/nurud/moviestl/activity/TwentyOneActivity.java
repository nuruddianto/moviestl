package com.example.nurud.moviestl.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.CityTheatreAdapter;
import com.example.nurud.moviestl.adapter.MovieDetailViewPagerAdapter;
import com.example.nurud.moviestl.fragment.TwentyOneTheatreFragment;
import com.example.nurud.moviestl.model.CityTheatre;
import com.example.nurud.moviestl.model.CityTheatreResponse;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;
import com.example.nurud.moviestl.rest.RestConstant;

import java.net.SocketTimeoutException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwentyOneActivity extends BaseActivity {
    private static final String TAG = TwentyOneTheatreFragment.class.getSimpleName();
    private CityTheatreAdapter mCityTheatreAdapter;

    @Optional
    @InjectView(R.id.city_theatre_recycler)
    RecyclerView mTheatreRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_one);

        ApiInterface apiInterface = BaseApiClient.getIbacorClient().create(ApiInterface.class);
        Call<CityTheatreResponse> call = apiInterface.getCitiesTheatre(RestConstant.IBACOR_API_KEY);
        call.enqueue(new Callback<CityTheatreResponse>() {
            @Override
            public void onResponse(Call<CityTheatreResponse> call, Response<CityTheatreResponse> response) {
                List<CityTheatre> citiesTheatre = response.body().getCitieTheatres();
                Log.d(TAG, String.format(getString(R.string.log_twenty_one_theatre), citiesTheatre.size()) );
                setViewPagerAdapter(citiesTheatre);
            }

            @Override
            public void onFailure(Call<CityTheatreResponse> call, Throwable t) {
                if(t instanceof SocketTimeoutException) {
                    Toast.makeText(mActivity, "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(mActivity, "Connection Error!", Toast.LENGTH_LONG).show();
                }
                Log.i("FAILURE", t.toString());
            }
        });
    }

    private void setViewPagerAdapter(List<CityTheatre>  citiesTheatre){
        mCityTheatreAdapter = new CityTheatreAdapter(citiesTheatre, R.layout.item_city_theatre, this);
        mTheatreRecycler.setLayoutManager(new LinearLayoutManager(this));
        mTheatreRecycler.setAdapter(mCityTheatreAdapter);
    }
}
