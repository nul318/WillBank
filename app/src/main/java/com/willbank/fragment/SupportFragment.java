package com.willbank.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.willbank.R;
import com.willbank.activity.ChatActivity;
import com.willbank.adapter.SupporterAdapter;
import com.willbank.instance.Supporter;

import java.util.ArrayList;


public class SupportFragment extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_support, container, false);

        ArrayList<Supporter> supportList = new ArrayList<>();
        supportList.add(new Supporter(R.drawable.supporter01, "헬스트레이너 김민성", "건강해지기!"));
        supportList.add(new Supporter(R.drawable.supporter02, "식단전문가 김아름", "맛있게, 즐겁게."));
        supportList.add(new Supporter(R.drawable.supporter03, "필라테스 강사 이유리", "반듯한 삶"));
        supportList.add(new Supporter(R.drawable.supporter04, "요가 강사 서지우", "여유와 즐거움"));
        supportList.add(new Supporter(R.drawable.profile_rank1, "식단코치 허승재", "먹는 것이 사는 것!"));
        supportList.add(new Supporter(R.drawable.profile_rank2, "개인자산가 연희영", ""));
        supportList.add(new Supporter(R.drawable.profile_rank3, "금연코치 한현범", "꼭! 우리함께"));
        supportList.add(new Supporter(R.drawable.profile_rank4, "헬스트레이너 김민성", "건강해지기!"));
        supportList.add(new Supporter(R.drawable.supporter02, "식단전문가 김아름", "맛있게, 즐겁게."));
        supportList.add(new Supporter(R.drawable.supporter03, "필라테스 강사 이유리", "반듯한 삶"));
        supportList.add(new Supporter(R.drawable.supporter04, "요가 강사 서지우", "여유와 즐거움"));
        supportList.add(new Supporter(R.drawable.profile_rank1, "식단코치 허승재", "먹는 것이 사는 것!"));
        supportList.add(new Supporter(R.drawable.profile_rank2, "개인자산가 연희영", ""));
        supportList.add(new Supporter(R.drawable.profile_rank3, "금연코치 한현범", "꼭! 우리함께"));
        supportList.add(new Supporter(R.drawable.profile_rank4, "헬스트레이너 김민성", "건강해지기!"));


        SupporterAdapter supporterAdapter = new SupporterAdapter(supportList, view.getContext(), R.layout.item_support);

        ListView supporterListView = (ListView) view.findViewById(R.id.supporter_list_view);
        supporterListView.setAdapter(supporterAdapter);
        supporterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), ChatActivity.class));
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });




        return view;
    }




}

