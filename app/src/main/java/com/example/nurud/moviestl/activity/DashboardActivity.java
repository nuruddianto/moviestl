package com.example.nurud.moviestl.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.DashboardViewPagerAdapter;
import com.example.nurud.moviestl.fragment.TopRatedFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DashboardActivity extends AppCompatActivity {
    private ActionBar mActionBar;

    @InjectView(R.id.toolbar)
    protected Toolbar mToolbar;
    @InjectView(R.id.tabs)
    protected TabLayout mTabLayout;
    @InjectView(R.id.dashboard_viewpager)
    protected ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        DashboardViewPagerAdapter adapter = new DashboardViewPagerAdapter(getSupportFragmentManager(), this);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabTextColors(R.color.colorWhite, R.color.colorAccentDark);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
        if(mToolbar != null){
            mToolbar.setTitle(R.string.movie_timeline);
            mToolbar.setTitleTextColor(Color.WHITE);
            setSupportActionBar(mToolbar);
        }
        mActionBar = getSupportActionBar();
        if(mActionBar != null){
            mActionBar.setDisplayHomeAsUpEnabled(false);
        }
    }


}
