package com.example.nurud.moviestl.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nurud.moviestl.fragment.TopRatedFragment;
import com.example.nurud.moviestl.fragment.UpcomingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRIN on 12/22/2016.
 */
public class DashboardViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmnets = new ArrayList<>();
    private final List<String> mTitleFragment = new ArrayList<>();

    public DashboardViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mFragmnets.add(new TopRatedFragment());
        mTitleFragment.add("Top 50");
        mFragmnets.add(new UpcomingFragment());
        mTitleFragment.add("Upcoming");
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmnets.get(position);
    }

    @Override
    public int getCount() {
        return mFragmnets.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleFragment.get(position);
    }
}
