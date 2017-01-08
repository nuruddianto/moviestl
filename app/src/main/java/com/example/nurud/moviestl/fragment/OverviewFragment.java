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
import com.example.nurud.moviestl.utility.DateFormatter;
import com.example.nurud.moviestl.activity.MovieDetailActivity;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.MovieDetail;
import com.example.nurud.moviestl.model.ProductionCompanies;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    private static final String TAG = OverviewFragment.class.getName();
    private Activity mActivity;
    private Movie mCurrentMovie;
    private MovieDetail mMovieDetail;

    @InjectView(R.id.movie_overview)
    protected WebView mMovieOverview;
    @InjectView(R.id.movie_detail_release_date)
    protected  TextView mReleaseDate;
    @InjectView(R.id.movie_detail_company_production)
    protected TextView mCompanyProduction;
    @InjectView(R.id.movie_detail_rating)
    protected TextView mRating;
    @InjectView(R.id.movie_detail_total_vote)
    protected TextView mTotalVote;
    @InjectView(R.id.movie_detail_duration)
    protected TextView mDuration;
    @InjectView(R.id.movie_detail_tagline)
    protected TextView mTagline;


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
            mMovieDetail = intent.getParcelableExtra(MovieDetailActivity.BUNDLE_MOVIE_DETAIL);
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
        if (mCurrentMovie == null && mMovieDetail == null) {
            return;
        }
        //Set up description webview
        String desc = "<html><body><p align=\"justify\">";
        desc += mCurrentMovie.getOverview();
        desc += "</p></body></html>";
        mMovieOverview.loadData(desc, "text/html", "utf-8");
        DateFormatter dateFormatter = new DateFormatter(mMovieDetail.getReleaseDate());
        mReleaseDate.setText(dateFormatter.change(mActivity));
        mRating.setText(String.valueOf(mMovieDetail.getVoteAverage()));
        mDuration.setText(String.format(getString(R.string.duration), String.valueOf(mMovieDetail.getRunTime())));
        mTotalVote.setText(String.valueOf(mMovieDetail.getVoteCount()));
        mTagline.setText(mMovieDetail.getTagLine());
        List<ProductionCompanies> productionCompanies = mMovieDetail.getProductionCompanies();
        String companies = "";
        for(int i =0; i < productionCompanies.size(); i++){
            companies += productionCompanies.get(i).getProuctionCompanyName();
            if(i != productionCompanies.size()-1){
                companies += ", ";
            }
        }
        mCompanyProduction.setText(companies);
    }
}
