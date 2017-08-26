package com.willbank.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.willbank.R;
import com.willbank.adapter.PagerAdapter;
import com.willbank.fragment.AnalyzeFragment;
import com.willbank.fragment.CommunityFragment;
import com.willbank.fragment.HomeFragment;
import com.willbank.fragment.SupportFragment;
import com.willbank.view.HomeViewPager;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

        HomeFragment homeFragment = new HomeFragment();
        AnalyzeFragment analyzeFragment = new AnalyzeFragment();
        CommunityFragment communityFragment = new CommunityFragment();
        SupportFragment supportFragment = new SupportFragment();

        adapter.addFragment(homeFragment, "1");
        adapter.addFragment(analyzeFragment, "2");
        adapter.addFragment(communityFragment, "3");
        adapter.addFragment(supportFragment, "4");

        HomeViewPager pager = (HomeViewPager) findViewById(R.id.view_pager);
        pager.setPagingEnabled(false);
        pager.setAdapter(adapter);
//        pager.setCurrentItem(0);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon1),
                        Color.argb(255,255,255,255)
                ).title("Home")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon2),
                        Color.argb(255,255,255,255)
                ).title("Analyze")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon3),
                        Color.argb(255,255,255,255)
                ).title("Community")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon4),
                        Color.argb(255,255,255,255)
                ).title("Support")
                        .build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(pager, 0);

        navigationTabBar.setBadgeTitleColor(Color.WHITE);



    }


}
