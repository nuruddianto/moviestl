package com.example.nurud.moviestl.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.adapter.DashboardViewPagerAdapter;

import java.util.List;

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
    @InjectView(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;
    @InjectView(R.id.left_drawer_list)
    protected ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.inject(this);
        DashboardViewPagerAdapter adapter = new DashboardViewPagerAdapter(getSupportFragmentManager(), this);

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
        if (mToolbar != null) {
            mToolbar.setTitle(R.string.movie_timeline);
            mToolbar.setTitleTextColor(Color.BLACK);
            setSupportActionBar(mToolbar);
        }
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(false);
        }
    }


}
