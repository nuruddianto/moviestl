package com.example.nurud.moviestl.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nurud.moviestl.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwentyOneTheatreFragment extends Fragment {


    public TwentyOneTheatreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_twenty_one_theatre, container, false);
    }

}