package com.example.nurud.moviestl.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.activity.MovieDetailActivity;
import com.example.nurud.moviestl.model.Movie;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    private static final String TAG = OverviewFragment.class.getName();
    private Activity mActivity;
    private Movie mCurrentMovie;

    @InjectView(R.id.movie_title_overview)
    protected TextView mMovieTitle;
    @InjectView(R.id.movie_overview)
    protected WebView mMovieOverview;

    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = mActivity.getIntent();
        if (intent != null) {
            mCurrentMovie = intent.getParcelableExtra(MovieDetailActivity.BUNDLE_MOVIE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        setView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //ButterKnife.reset(this);
    }

    private void setView() {
        if (mCurrentMovie == null) {
            return;
        }
        mMovieTitle.setText(mCurrentMovie.getTitle());
        //Set up description webview
        String desc = "<html><body><p align=\"justify\">";
        desc += mCurrentMovie.getOverview();
        desc += "</p></body></html>";
        mMovieOverview.loadData(desc, "text/html", "utf-8");
    }
}
