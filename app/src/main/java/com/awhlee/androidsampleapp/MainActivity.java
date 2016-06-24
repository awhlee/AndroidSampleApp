package com.awhlee.androidsampleapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    MainActivityFragment mFragment = new MainActivityFragment();
    MainActivityFragment2 mFragment2 = new MainActivityFragment2();
    boolean mMainFragmentEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        setupTabs();

        enableFragment(mFragment);
        mMainFragmentEnabled = true;
    }

    private void setupTabs() {
        mTabLayout.addTab(mTabLayout.newTab().setText("Fragment 1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Fragment 2"));
        mTabLayout.setTabTextColors(0xFFD3D3D3, 0xFF920485);
        mTabLayout.setSelectedTabIndicatorColor(0xFF920485);
        mTabLayout.setSelectedTabIndicatorHeight(20);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 if(mTabLayout.getSelectedTabPosition() == 0) {
                    enableFragment(mFragment);
                 } else {
                     enableFragment(mFragment2);
                 }
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {}

             @Override
             public void onTabReselected(TabLayout.Tab tab) {}
         });
    }

    private void enableFragment(Fragment fragment) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_activity_fragment, fragment);
            transaction.commitAllowingStateLoss();
        } catch (IllegalStateException ise) {
            Log.e("SampleApp", "Error encountered!");
            Log.e("SampleApp", ise.toString());
        }
    }

    private void toggleFragment() {
        if (mMainFragmentEnabled) {
            mMainFragmentEnabled = false;
            enableFragment(mFragment2);
        } else {
            mMainFragmentEnabled = true;
            enableFragment(mFragment);
        }
    }

    private void toggleTabs() {
        if (mTabLayout.getVisibility() == View.GONE) {
            mTabLayout.setVisibility(View.VISIBLE);
        } else {
            mTabLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            toggleTabs();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
