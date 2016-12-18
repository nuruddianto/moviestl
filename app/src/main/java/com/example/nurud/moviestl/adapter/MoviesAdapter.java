package com.example.nurud.moviestl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.model.Movie;

import java.util.List;

/**
 * Created by nurud on 18/12/2016.
 */

public  class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private int rowLayout;
    private Context mContext;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView subtitle;
        TextView movieDescription;
        TextView rating;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView)v.findViewById(R.id.title);
            subtitle = (TextView)v.findViewById(R.id.subtitle);
            movieDescription = (TextView)v.findViewById(R.id.description);
            rating = (TextView)v.findViewById(R.id.rating);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context mContext) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.mContext = mContext;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.subtitle.setText(movies.get(position).getReleasDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(String.valueOf(movies.get(position).getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
