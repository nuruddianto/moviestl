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

import java.util.List;

/**
 * Created by nurud on 24/12/2016.
 */

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.CardViewHolder> {
    private List<Movie> mUpcomingMovies;
    private int rowLayout;
    private Context mContext;

    public class CardViewHolder extends RecyclerView.ViewHolder {
        View cardView;
        ImageView upcomingImage;
        TextView titleUpcomingMovie;
        TextView releaseDate;
        TextView ratingUpcoming;
        TextView popularityUpcoming;

        public CardViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.card_view);
            upcomingImage = (ImageView) v.findViewById(R.id.image_upcoming);
            titleUpcomingMovie = (TextView) v.findViewById(R.id.title_upcoming_movie);
            releaseDate = (TextView) v.findViewById(R.id.release_date);
            ratingUpcoming = (TextView) v.findViewById(R.id.movie_upcoming_rating);
            popularityUpcoming = (TextView) v.findViewById(R.id.movie_upcoming_popularity);

        }
    }

    public UpcomingAdapter(Context context, int rowLayout, List<Movie> mUpcomingMovies) {
        this.mContext = context;
        this.rowLayout = rowLayout;
        this.mUpcomingMovies = mUpcomingMovies;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int position) {
        RequestCreator requestCreator;
        int defaultUpcomingImage = R.drawable.icon_app_movie_ciano;

        if (mUpcomingMovies.get(position).getPosterPath() != null) {
            requestCreator = Picasso.with(mContext).load(Uri.parse("http://image.tmdb.org/t/p/w500" + mUpcomingMovies.get(position).getBackdropPath()));
        } else {
            requestCreator = Picasso.with(mContext).load(defaultUpcomingImage);
        }

        requestCreator.placeholder(defaultUpcomingImage)
                .noFade()
                .fit()
                .into(holder.upcomingImage);

        holder.titleUpcomingMovie.setText(mUpcomingMovies.get(position).getTitle());
        holder.releaseDate.setText(String.format(mContext.getString(R.string.movie_release_date), mUpcomingMovies.get(position).getReleasDate()));
        holder.ratingUpcoming.setText(String.valueOf(mUpcomingMovies.get(position).getVoteAverage()));
        holder.popularityUpcoming.setText(String.valueOf(mUpcomingMovies.get(position).getPopularity()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.goToMovieDetail((Activity) holder.itemView.getContext(), mUpcomingMovies.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUpcomingMovies.size();
    }
}
