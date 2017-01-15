package com.example.nurud.moviestl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.model.ShowTimeTheatre;
import com.example.nurud.moviestl.model.Showtime;
import com.example.nurud.moviestl.utility.FlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRIN on 1/9/2017.
 */
public class ShowTimeTheatreAdapter extends RecyclerView.Adapter<ShowTimeTheatreAdapter.ShowTimeViewHolder> {
    private List<ShowTimeTheatre> mShowTimeTheatres;
    private Context mContext;

    public ShowTimeTheatreAdapter(List<ShowTimeTheatre> showTimeTheatres, Context context) {
        this.mShowTimeTheatres = showTimeTheatres;
        this.mContext = context;
    }

    static class ShowTimeViewHolder extends RecyclerView.ViewHolder {
        TextView showLocation;
        FlowLayout lyTime;
        TextView price;

        public ShowTimeViewHolder(View v) {
            super(v);
            showLocation = (TextView)v.findViewById(R.id.show_time_theatre);
            lyTime = (FlowLayout)v.findViewById(R.id.lyTime);
            price = (TextView)v.findViewById(R.id.price_theatre);
        }
    }

    @Override
    public ShowTimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show_time_theatre, parent, false);
        return new ShowTimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowTimeViewHolder holder, int position) {
        final ShowTimeTheatre currentShowTime = mShowTimeTheatres.get(position);
        holder.price.setText(currentShowTime.getPrice());
        holder.showLocation.setText(currentShowTime.getTheatre());


        for(int i=0; i < currentShowTime.getTime().size(); i++){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_time_theatre, holder.lyTime, false);
            TextView time = (TextView) view.findViewById(R.id.time);
            time.setText(currentShowTime.getTime().get(i));
            holder.lyTime.addView(view);
        }
    }

    @Override
    public int getItemCount() {
        return mShowTimeTheatres.size();
    }
}
