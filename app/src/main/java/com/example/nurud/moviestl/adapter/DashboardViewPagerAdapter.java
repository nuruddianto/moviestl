package com.example.nurud.moviestl.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.fragment.HomeFragment;
import com.example.nurud.moviestl.fragment.TopRatedFragment;
import com.example.nurud.moviestl.fragment.UpcomingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurudianto on 12/22/2016.
 */
public class DashboardViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mTitleFragment = new ArrayList<>();

    public DashboardViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mFragments.add(new HomeFragment());
        mTitleFragment.add(context.getString(R.string.home_dashboard_menu_pager));
        mFragments.add(new UpcomingFragment());
        mTitleFragment.add(context.getString(R.string.upcoming_dashboard_menu_pager));
        mFragments.add(new TopRatedFragment());
        mTitleFragment.add(context.getString(R.string.top_rated));
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleFragment.get(position);
    }
}
