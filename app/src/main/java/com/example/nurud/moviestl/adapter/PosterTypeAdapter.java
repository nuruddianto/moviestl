package com.example.nurud.moviestl.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.model.Movie;
import com.example.nurud.moviestl.model.PosterType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nurud on 01/01/2017.
 */

public class PosterTypeAdapter implements ExpandableListAdapter {
    private Context mContext;
    private List<PosterType> mPosterType = new ArrayList<>();

    public PosterTypeAdapter(Context context, List<PosterType> posterType) {
        this.mContext = context;
        this.mPosterType = posterType;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getGroupCount() {
        return mPosterType.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mPosterType.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mPosterType.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        ParentHolder parentHolder =null;
        Movie movie = (Movie)getGroup(groupPosition);

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_home_poster_parent, null);
            view.setHorizontalScrollBarEnabled(true);

            parentHolder = new ParentHolder();
            view.setTag(parentHolder);
        }else{
            parentHolder = (ParentHolder)view.getTag();
        }

        parentHolder.posterTypeName = (TextView)view.findViewById(R.id.text_poster_type);
        parentHolder.posterTypeName.setText(movie.getTitle());

        parentHolder.indicator = (ImageView)view.findViewById(R.id.image_indicator);

        if(isExpanded){
            parentHolder.indicator.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24px);
        }else{
            parentHolder.indicator.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24px);
        }

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_home_poster_group_child, parent, false);
            childHolder = new ChildHolder();
            convertView.setTag(childHolder);
        }
        else {
            childHolder = (ChildHolder) convertView.getTag();
        }

        childHolder.horizontalListView = (RecyclerView) convertView.findViewById(R.id.mobiles);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        childHolder.horizontalListView.setLayoutManager(layoutManager);

        PosterAdapter horizontalListAdapter = new PosterAdapter(mContext, mPosterType.get(groupPosition).mMovies);
        childHolder.horizontalListView.setAdapter(horizontalListAdapter);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return 0;
    }

    private static class ChildHolder {
        static RecyclerView horizontalListView;
    }

    private static class ParentHolder {
        TextView posterTypeName;
        ImageView indicator;
    }
}
