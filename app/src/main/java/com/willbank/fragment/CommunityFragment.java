package com.willbank.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.willbank.R;
import com.willbank.adapter.CommunityAdapter;
import com.willbank.instance.Community;

import java.util.ArrayList;


public class CommunityFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_community, container, false);


        ArrayList<Community> communityList = new ArrayList<>();
        communityList.add(new Community(R.mipmap.ic_launcher, "강아지와 산책할 분 모여요", 10, "8/13"));
        communityList.add(new Community(R.mipmap.ic_launcher, "수영 최고!", 13, "8/13"));
        communityList.add(new Community(R.mipmap.ic_launcher, "1일 1베이킹 도전!", 9, "8/12"));
        communityList.add(new Community(R.mipmap.ic_launcher, "인문학 서적 추천해요", 32, "8/12"));
        communityList.add(new Community(R.mipmap.ic_launcher, "도전! 한강라이딩", 22, "8/11"));
        communityList.add(new Community(R.mipmap.ic_launcher, "강아지와 산책할 분 모여요", 10, "8/13"));
        communityList.add(new Community(R.mipmap.ic_launcher, "수영 최고!", 13, "8/13"));
        communityList.add(new Community(R.mipmap.ic_launcher, "1일 1베이킹 도전!", 9, "8/12"));
        communityList.add(new Community(R.mipmap.ic_launcher, "인문학 서적 추천해요", 32, "8/12"));
        communityList.add(new Community(R.mipmap.ic_launcher, "도전! 한강라이딩", 22, "8/11"));
        communityList.add(new Community(R.mipmap.ic_launcher, "강아지와 산책할 분 모여요", 10, "8/13"));
        communityList.add(new Community(R.mipmap.ic_launcher, "수영 최고!", 13, "8/13"));
        communityList.add(new Community(R.mipmap.ic_launcher, "1일 1베이킹 도전!", 9, "8/12"));
        communityList.add(new Community(R.mipmap.ic_launcher, "인문학 서적 추천해요", 32, "8/12"));
        communityList.add(new Community(R.mipmap.ic_launcher, "도전! 한강라이딩", 22, "8/11"));


        CommunityAdapter communityAdapter = new CommunityAdapter(communityList, view.getContext(), R.layout.item_community);

        ListView communityListView = (ListView) view.findViewById(R.id.community_list_view);
        communityListView.setAdapter(communityAdapter);




        return view;
    }




}

