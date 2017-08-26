package com.willbank.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.willbank.R;
import com.willbank.adapter.CommunityTabAdapter;


public class CommunityFragment extends Fragment {

    CommunityTabAdapter adapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_community, container, false);


        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        adapter = new CommunityTabAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new TalkFragment(), "Talk");
        adapter.addFragment(new ArchiveFragment(), "Archive");
        adapter.addFragment(new RankFragment(), "Ranking");


        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return view;
    }



}

