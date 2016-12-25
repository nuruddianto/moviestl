package com.example.nurud.moviestl.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.Router;
import com.example.nurud.moviestl.model.Movie;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;

/**
 * Created by nurud on 18/12/2016.
 */

public class TopRatedAdapter extends RecyclerView.Adapter<TopRatedAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private int rowLayout;
    private Context mContext;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView subtitle;
        TextView movieDescription;
        TextView rating;
        ImageView movieImage;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            subtitle = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            movieImage = (ImageView) v.findViewById(R.id.movie_image);
        }
    }

    public TopRatedAdapter(List<Movie> movies, int rowLayout, Context mContext) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
        RequestCreator requestCreator;
        int defaultBannerDrawable = R.drawable.ic_movie_ciano_24px;

        if (movies.get(position).getPosterPath() != null) {
            requestCreator = Picasso.with(holder.movieImage.getContext()).load(Uri.parse("http://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath()));
        } else {
            requestCreator = Picasso.with(holder.movieImage.getContext()).load(defaultBannerDrawable);
        }

        requestCreator.placeholder(defaultBannerDrawable)
                .noFade()
                .fit()
                .into(holder.movieImage);

        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.subtitle.setText(String.format(movies.get(position).getReleasDate()));
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(String.valueOf(movies.get(position).getVoteAverage()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.goToMovieDetail((Activity) holder.itemView.getContext(), movies.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}