package com.example.nurud.moviestl.rest;

import android.support.v7.widget.RecyclerView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nurud on 18/12/2016.
 */

public class BaseApiClient {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String BASE_IBACOR_URL = "http://ibacor.com";
    public static Retrofit retrofit = null;
    public static Retrofit mIbacorRetrofit;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getIbacorClient(){
        if(mIbacorRetrofit == null){
            mIbacorRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_IBACOR_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mIbacorRetrofit;
    }
}
