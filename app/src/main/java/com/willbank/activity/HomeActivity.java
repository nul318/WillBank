package com.willbank.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.willbank.R;
import com.willbank.adapter.PagerAdapter;
import com.willbank.fragment.CertifyFragment;
import com.willbank.fragment.CommunityFragment;
import com.willbank.fragment.HomeFragment;
import com.willbank.fragment.SettingsFragment;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

        HomeFragment homeFragment = new HomeFragment();
        CertifyFragment certifyFragment = new CertifyFragment();
        CommunityFragment communityFragment = new CommunityFragment();
        SettingsFragment settingsFragment = new SettingsFragment();

        adapter.addFragment(homeFragment, "1");
        adapter.addFragment(certifyFragment, "2");
        adapter.addFragment(communityFragment, "3");
        adapter.addFragment(settingsFragment, "4");

        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(adapter);
//        pager.setCurrentItem(0);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.mipmap.ic_launcher),
                        Color.parseColor("#FFFFFF")
                ).title("Home")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.mipmap.ic_launcher),
                        Color.parseColor("#FFFFFF")
                ).title("Certify")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.mipmap.ic_launcher),
                        Color.parseColor("#FFFFFF")
                ).title("Community")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.mipmap.ic_launcher),
                        Color.parseColor("#FFFFFF")
                ).title("Settings")
                        .build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(pager, 0);
        navigationTabBar.setBadgeTitleColor(Color.WHITE);



    }


}
