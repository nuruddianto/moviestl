package com.example.nurud.moviestl.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.Router;
import com.example.nurud.moviestl.utility.ImageSliderView;
import com.example.nurud.moviestl.adapter.PosterTypeAdapter;
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
public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @InjectView(R.id.list_poster_type)
    ExpandableListView mPosterListView;

    private List<PosterType> mPosterTypes = new ArrayList<>();
    private ExpandableListAdapter mPosterTypeAdapter;
    private Activity mActivity;
    private Context mContext;
    private ApiInterface mApiInterface;

    @InjectView(R.id.image_slider)
    SliderLayout mImageSlider;

    private static final String TAG = HomeFragment.class.getSimpleName();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        mContext = getContext();
        mApiInterface = BaseApiClient.getTmdbClient().create(ApiInterface.class);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        getTopRatedData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    /*Synchroniously call retrofit*/
    private void setAdapter() {
        mPosterTypeAdapter = new PosterTypeAdapter(mContext, mPosterTypes);
        mPosterListView.setAdapter(mPosterTypeAdapter);
        for(int i =0; i < 3; i++){
            mPosterListView.expandGroup(i);
        }
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(mPosterListView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < mPosterTypeAdapter.getGroupCount(); i++) {
            View groupItem = mPosterTypeAdapter.getGroupView(i, false, null, mPosterListView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((mPosterListView.isGroupExpanded(i)))
                    || ((!mPosterListView.isGroupExpanded(i)) )){
                for (int j = 0; j < mPosterTypeAdapter.getChildrenCount(i); j++) {
                    View listItem = mPosterTypeAdapter.getChildView(i, j, false, null,
                            mPosterListView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                    totalHeight += listItem.getMeasuredHeight();
                }
            }
        }

        ViewGroup.LayoutParams params = mPosterListView.getLayoutParams();
        int height = totalHeight + 100
                + (mPosterListView.getDividerHeight() * (mPosterTypeAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        mPosterListView.setLayoutParams(params);
        mPosterListView.requestLayout();
    }

    private void getTopRatedData() {
        Call<MovieResponse> call = mApiInterface.getTopRatedMovies(RestConstant.TMDB_API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> topRatedList = response.body().getResults();
                PosterType topRated = new PosterType(getString(R.string.top_rated), topRatedList);
                mPosterTypes.add(topRated);
                getNowPlayingData();
                Log.d(TAG, String.format(mContext.getString(R.string.log_success_top_rated_movies), topRatedList.size()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
                Log.d(TAG, mContext.getString(R.string.log_success_top_rated_movies));
            }
        });
    }

    private void getNowPlayingData() {
        Call<MovieResponse> call = mApiInterface.getNowPlayingMovies(RestConstant.TMDB_API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> nowPlayingList = response.body().getResults();
                PosterType nowPlaying = new PosterType(getString(R.string.now_playing), nowPlayingList);
                mPosterTypes.add(nowPlaying);
                getUpcomingData();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void getUpcomingData() {
        Call<MovieResponse> call = mApiInterface.getUpcominMovies(RestConstant.TMDB_API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> upcomingList = response.body().getResults();
                PosterType upcoming = new PosterType("Upcoming", upcomingList);
                mPosterTypes.add(upcoming);
                setAdapter();
                setImageSliderData(upcomingList);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }

    private void setImageSliderData(List<Movie> movies) {
        for (final Movie movie : movies) {
            ImageSliderView textSliderView = new ImageSliderView(mContext, movie);
            /*initialize slider layout*/
            textSliderView.description(movie.getTitle())
                    .image(String.format(getString(R.string.image_url), movie.getBackdropPath()))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            Router.goToMovieDetail(mActivity, movie);
                        }
                    });
            mImageSlider.addSlider(textSliderView);
        }
        mImageSlider.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        mImageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Left_Top);
        mImageSlider.setCustomAnimation(new DescriptionAnimation());
        mImageSlider.setDuration(8000);
        mImageSlider.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

}
