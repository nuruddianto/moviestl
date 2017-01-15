package com.example.nurud.moviestl.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.Router;
import com.example.nurud.moviestl.model.MovieTheatre;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;

/**
 * Created by SRIN on 1/9/2017.
 */
public class MovieTheatreAdapter extends RecyclerView.Adapter<MovieTheatreAdapter.MovieTheatreViewHolder> {
    private List<MovieTheatre> mMovieTheatre;
    private int mRowLayout;
    private String mMovieDate;
    private Context mContext;

    public MovieTheatreAdapter(List<MovieTheatre> movieTheatres, int rowLayout, Context context, String movieDate) {
        this.mMovieTheatre = movieTheatres;
        this.mRowLayout = rowLayout;
        this.mContext = context;
        this.mMovieDate = movieDate;
    }

    public class MovieTheatreViewHolder extends RecyclerView.ViewHolder {
        ImageView posterMovieTheatre;
        TextView titleMovieTheatre;
        TextView genreMovieTheatre;
        TextView durationMovieTheatre;

        public MovieTheatreViewHolder(View v) {
            super(v);
            posterMovieTheatre = (ImageView)v.findViewById(R.id.poster_movie_theatre );
            titleMovieTheatre = (TextView)v.findViewById(R.id.title_movie_theatre);
            genreMovieTheatre = (TextView)v.findViewById(R.id.genre_movie_theatre);
            durationMovieTheatre = (TextView)v.findViewById(R.id.duration_movie_theatre);
        }
    }

    @Override
    public MovieTheatreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayout, parent, false);
        return new MovieTheatreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieTheatreViewHolder holder, int position) {
        RequestCreator requestCreator;
        int posterDrawable = R.drawable.ic_movie_ciano_24px;
        final MovieTheatre currentMovie = mMovieTheatre.get(position);

        if(mMovieTheatre.get(position).getPoster() != null){
            requestCreator = Picasso.with(holder.posterMovieTheatre.getContext()).load(currentMovie.getPoster());
        }else{
            requestCreator = Picasso.with(holder.posterMovieTheatre.getContext()).load(posterDrawable);
        }

        requestCreator.placeholder(posterDrawable)
                .fit()
                .into(holder.posterMovieTheatre);

        holder.titleMovieTheatre.setText(currentMovie.getMovie());
        holder.genreMovieTheatre.setText(currentMovie.getGenre());
        holder.durationMovieTheatre.setText(currentMovie.getDuration());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.goToShowTimeTheatre((Activity)holder.itemView.getContext(), currentMovie, mMovieDate);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieTheatre.size();
    }
}
