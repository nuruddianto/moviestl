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
import com.example.nurud.moviestl.model.Movie;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nurud on 01/01/2017.
 */

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.ViewHolder> {
    private Context mContext;
    private List<Movie> mMovies = new ArrayList<>();

    public PosterAdapter(Context context, List<Movie> movies) {
        this.mContext = context;
        this.mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cardView = inflater.inflate(R.layout.item_home_poster_child, null, false);
        ViewHolder viewHolder = new ViewHolder(cardView);
        viewHolder.movieImage = (ImageView) cardView.findViewById(R.id.image_movie_poster);
        viewHolder.movieName = (TextView) cardView.findViewById(R.id.text_movie_name);
        viewHolder.movieRating = (TextView) cardView.findViewById(R.id.poster_rating);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        RequestCreator requestCreator;
        int defaultBannerDrawable = R.drawable.ic_movie_ciano_24px;

        if (mMovies.get(position).getPosterPath() != null) {
            requestCreator = Picasso.with(holder.movieImage.getContext())
                    .load(Uri.parse("http://image.tmdb.org/t/p/w500" + mMovies.get(position).getPosterPath()));
        } else {
            requestCreator = Picasso.with(holder.movieImage.getContext())
                    .load(defaultBannerDrawable);
        }

        requestCreator.placeholder(defaultBannerDrawable)
                .noFade()
                .fit()
                .into(holder.movieImage);

        holder.movieName.setText(mMovies.get(position).getTitle());
        holder.movieRating.setText(String.valueOf(mMovies.get(position).getVoteAverage()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.goToMovieDetail((Activity)holder.itemView.getContext(), mMovies.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView movieImage;
        TextView movieName;
        TextView movieRating;

        public ViewHolder(View itemView) {
            super(itemView);
            movieImage = (ImageView) itemView.findViewById(R.id.image_movie_poster);
            movieName = (TextView) itemView.findViewById(R.id.text_movie_name);
            movieRating = (TextView) itemView.findViewById(R.id.poster_rating);
        }
    }
}
