package com.example.nurud.moviestl.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.activity.MovieDetailActivity;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.MovieVideo;
import com.example.nurud.moviestl.model.MovieVideoResponse;
import com.example.nurud.moviestl.rest.ApiInterface;
import com.example.nurud.moviestl.rest.BaseApiClient;
import com.example.nurud.moviestl.rest.RestConstant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {

    @InjectView(R.id.img_movie_2x1)
    protected ImageView mImageMovie;
    @InjectView(R.id.movie_title)
    TextView mMovieTitle;
    @InjectView(R.id.movie_description)
    WebView mMovieDescription;
    @InjectView(R.id.movie_detail_rating)
    TextView mRating;
    @InjectView(R.id.movie_detail_total_vote)
    TextView mVoteCount;

    private static final String TAG = MovieDetailFragment.class.getSimpleName();
    private Activity mActivity;
    private Movie mCurrentMovie;

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
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
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
        ButterKnife.reset(this);
    }

    private void setView() {
        if (mCurrentMovie == null) {
            return;
        }
        int defaultImageDrawable = R.drawable.icon_app_movie_ciano;
        Picasso.with(mActivity).load(Uri.parse("http://image.tmdb.org/t/p/w500" + mCurrentMovie.getBackdropPath()))
                .placeholder(defaultImageDrawable)
                .noFade()
                .fit()
                .into(mImageMovie);

        mImageMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface apiInterface = BaseApiClient.getClient().create(ApiInterface.class);
                Call<MovieVideoResponse> call = apiInterface.getMovieVideo(mCurrentMovie.getId(), RestConstant.API_KEY);
                call.enqueue(new Callback<MovieVideoResponse>() {
                    @Override
                    public void onResponse(Call<MovieVideoResponse> call, Response<MovieVideoResponse> response) {
                        List<MovieVideo> video = response.body().getResults();
                        String videoUrl = "";
                        videoUrl = String.format(getString(R.string.youtube_url), video.get(video.size() - 1).getVideoKey());

                        mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)));
                    }

                    @Override
                    public void onFailure(Call<MovieVideoResponse> call, Throwable t) {
                        Log.e(TAG, t.toString());
                    }
                });
            }
        });
        mMovieTitle.setText(mCurrentMovie.getTitle());
        //Set up description webview
        String desc = "<html><body><p align=\"justify\">";
        desc += mCurrentMovie.getOverview();
        desc += "</p></body></html>";
        mMovieDescription.loadData(desc, "text/html", "utf-8");
        mRating.setText(String.valueOf(mCurrentMovie.getVoteAverage()));
        mVoteCount.setText(String.valueOf(mCurrentMovie.getVoteCount()));
    }
}
