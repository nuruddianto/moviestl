package com.example.nurud.moviestl.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.Router;
import com.example.nurud.moviestl.Utility.DateFormatter;
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
        View topRatedCardView;
        TextView topRatedNumber;
        TextView topRatedTitle;
        TextView releaseDate;
        TextView ratingTopRated;
        TextView voteCountTopRated;
        ImageView topRatedImage;

        public MovieViewHolder(View v) {
            super(v);
            topRatedCardView = v.findViewById(R.id.top_rated_card_view);
            topRatedNumber = (TextView) v.findViewById(R.id.top_rated_number);
            topRatedTitle = (TextView) v.findViewById(R.id.title_top_rated);
            releaseDate = (TextView) v.findViewById(R.id.release_date_top_rated);
            ratingTopRated = (TextView) v.findViewById(R.id.rating_top_rated);
            voteCountTopRated = (TextView) v.findViewById(R.id.vote_count_top_rated);
            topRatedImage = (ImageView) v.findViewById(R.id.image_movie_top_rated);
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
            requestCreator = Picasso.with(holder.topRatedImage.getContext()).load(Uri.parse("http://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath()));
        } else {
            requestCreator = Picasso.with(holder.topRatedImage.getContext()).load(defaultBannerDrawable);
        }

        requestCreator.placeholder(defaultBannerDrawable)
                .noFade()
                .fit()
                .into(holder.topRatedImage);

        holder.topRatedNumber.setText(String.valueOf(position + 1 + ". "));
        holder.topRatedTitle.setText(movies.get(position).getTitle());
        DateFormatter dateFormatter = new DateFormatter(movies.get(position).getReleasDate());
        holder.releaseDate.setText(dateFormatter.doFormat(mContext));
        holder.voteCountTopRated.setText(String.valueOf(movies.get(position).getVoteCount()));
        holder.ratingTopRated.setText(String.valueOf(movies.get(position).getVoteAverage()));

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
