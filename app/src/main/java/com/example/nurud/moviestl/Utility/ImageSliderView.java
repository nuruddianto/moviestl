package com.example.nurud.moviestl.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.model.Movie;

/**
 * Created by Nurudianto on 1/3/2017.
 */
public class ImageSliderView extends BaseSliderView {
    private Movie mMovie;

    public ImageSliderView(Context context, Movie movie) {
        super(context);
        mMovie = movie;
    }

    @Override
    public View getView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.render_image_slider, null);
        ImageView target = (ImageView) view.findViewById(R.id.daimajia_slider_image);
        TextView description = (TextView) view.findViewById(R.id.description);
        description.setText(getDescription());
        TextView rating = (TextView) view.findViewById(R.id.image_slider_rating);
        rating.setText(String.valueOf(mMovie.getVoteAverage()));
        bindEventAndShow(view, target);
        return view;
    }

}
