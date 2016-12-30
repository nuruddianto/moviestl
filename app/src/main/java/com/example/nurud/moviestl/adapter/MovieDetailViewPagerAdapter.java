package com.example.nurud.moviestl.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nurud.moviestl.fragment.OverviewFragment;
import com.example.nurud.moviestl.fragment.ReviewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRIN on 12/29/2016.
 */
public class MovieDetailViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mTitleFragment = new ArrayList<>();

    public MovieDetailViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mFragments.add(new OverviewFragment());
        mTitleFragment.add("Overview");
        mFragments.add(new ReviewFragment());
        mTitleFragment.add("Review");
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
