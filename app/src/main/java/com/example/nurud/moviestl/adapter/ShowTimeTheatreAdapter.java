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

import java.util.List;

/**
 * Created by SRIN on 1/9/2017.
 */
public class ShowTimeTheatreAdapter extends RecyclerView.Adapter<ShowTimeTheatreAdapter.ShowTimeViewHolder> {
    private List<ShowTimeTheatre> mShowTimeTheatres;
    private List<Showtime> mShowTime;
    private int mRowLayout;
    private Context mContext;

    public ShowTimeTheatreAdapter(List<ShowTimeTheatre> mShowTimeTheatres, int mRowLayout, Context mContext) {
        this.mShowTimeTheatres = mShowTimeTheatres;
        this.mRowLayout = mRowLayout;
        this.mContext = mContext;
    }

    static class ShowTimeViewHolder extends RecyclerView.ViewHolder {
        TextView showTime;
        FlowLayout lyTime;
        TextView price;

        public ShowTimeViewHolder(View v) {
            super(v);
            showTime = (TextView)v.findViewById(R.id.show_time_theatre);
            lyTime = (FlowLayout)v.findViewById(R.id.lyTime);
            price = (TextView)v.findViewById(R.id.price_theatre);
        }
    }

    @Override
    public ShowTimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayout, parent, false);
        return new ShowTimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowTimeViewHolder holder, int position) {
        ShowTimeTheatre currentShowTime = mShowTimeTheatres.get(position);
        holder.showTime.setText(currentShowTime.getTheatre());
        holder.price.setText(currentShowTime.getPrice());

        final Showtime showtime = mShowTime.get(position);
        for(int i=0; i < currentShowTime.getTime().size(); i++){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_show_time_theatre, holder.lyTime, false);
            TextView time = (TextView) view.findViewById(R.id.time);
            time.setText(showtime.getJam().get(i));
            holder.lyTime.addView(view);
        }
    }

    @Override
    public int getItemCount() {
        return mShowTimeTheatres.size();
    }
}
