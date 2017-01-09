package com.example.nurud.moviestl.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.Router;
import com.example.nurud.moviestl.model.CityTheatre;

import java.util.List;

/**
 * Created by SRIN on 1/9/2017.
 */
public class CityTheatreAdapter extends RecyclerView.Adapter<CityTheatreAdapter.CityViewHolder> {
    private List<CityTheatre> mCityList;
    private int mRowLayout;
    private Context mContext;

    public CityTheatreAdapter(List<CityTheatre> mCityList, int mRowLayout, Context mContext) {
        this.mCityList = mCityList;
        this.mRowLayout = mRowLayout;
        this.mContext = mContext;
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        TextView mCityName;

        public CityViewHolder(View v) {
            super(v);
            mCityName = (TextView) v.findViewById(R.id.city_theatre);
        }
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayout, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CityViewHolder holder, final int position) {
        holder.mCityName.setText(mCityList.get(position).getCity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.goToMovieTheatre((Activity) holder.itemView.getContext(), mCityList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }
}
