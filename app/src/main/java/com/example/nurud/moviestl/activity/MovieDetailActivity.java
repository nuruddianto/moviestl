package com.example.nurud.moviestl.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nurud.moviestl.R;
import com.example.nurud.moviestl.fragment.MovieDetailFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MovieDetailActivity extends AppCompatActivity {
    private ActionBar mActionBar;

    @InjectView(R.id.toolbar)
    protected Toolbar mToolbar;
    public static final String BUNDLE_MOVIE = "BUNDLE_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Fragment fragment = new MovieDetailFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
        if (mToolbar != null) {
            mToolbar.setTitle(getString(R.string.movie_detail));
            mToolbar.setTitleTextColor(Color.BLACK);
            setSupportActionBar(mToolbar);
        }
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
