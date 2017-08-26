package com.willbank.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.willbank.R;
import com.willbank.adapter.TalkAdapter;
import com.willbank.instance.Talk;

import java.util.ArrayList;


public class TalkFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_talk, container, false);


        ArrayList<Talk> talkList = new ArrayList<>();
        talkList.add(new Talk(R.drawable.talk1, "강아지를 좋아하는 모임", 10, "8/13"));
        talkList.add(new Talk(R.drawable.talk2, "수영 최고!", 13, "8/13"));
        talkList.add(new Talk(R.drawable.talk3, "1일 1베이킹 도전!", 9, "8/12"));
        talkList.add(new Talk(R.drawable.talk1, "인문학 서적 추천해요", 32, "8/12"));
        talkList.add(new Talk(R.drawable.talk2, "도전! 한강라이딩", 22, "8/11"));
        talkList.add(new Talk(R.drawable.talk1, "강아지를 좋아하는 모임", 10, "8/13"));
        talkList.add(new Talk(R.drawable.talk2, "수영 최고!", 13, "8/13"));
        talkList.add(new Talk(R.drawable.talk3, "1일 1베이킹 도전!", 9, "8/12"));
        talkList.add(new Talk(R.drawable.talk1, "인문학 서적 추천해요", 32, "8/12"));
        talkList.add(new Talk(R.drawable.talk2, "도전! 한강라이딩", 22, "8/11"));
        talkList.add(new Talk(R.drawable.talk1, "강아지를 좋아하는 모임", 10, "8/13"));
        talkList.add(new Talk(R.drawable.talk2, "수영 최고!", 13, "8/13"));
        talkList.add(new Talk(R.drawable.talk3, "1일 1베이킹 도전!", 9, "8/12"));
        talkList.add(new Talk(R.drawable.talk1, "인문학 서적 추천해요", 32, "8/12"));
        talkList.add(new Talk(R.drawable.talk2, "도전! 한강라이딩", 22, "8/11"));


        TalkAdapter talkAdapter = new TalkAdapter(talkList, view.getContext(), R.layout.item_talk);

        GridView communityListView = (GridView) view.findViewById(R.id.community_grid_view);
        communityListView.setAdapter(talkAdapter);


        return view;
    }


}

