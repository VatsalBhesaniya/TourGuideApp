package com.example.android.tourguideapp;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        //Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        setupVeiwPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupVeiwPager(ViewPager veiwPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RestuarantsFragment(), "Restuarants");
        adapter.addFragment(new AttractionsFragment(), "Attractions");
        adapter.addFragment(new ShoppingMallsFragment(), "Shopping Malls");
        adapter.addFragment(new MovieTheatersFragment(), "Movie Theaters");
        adapter.addFragment(new HotelsFragment(), "Hotels");
        adapter.addFragment(new PublicTransitFragment(), "Public Transit");
        veiwPager.setAdapter(adapter);
    }
}
