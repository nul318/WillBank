package com.willbank.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.willbank.R;
import com.willbank.adapter.RankAdapter;
import com.willbank.instance.Rank;

import java.util.ArrayList;


public class RankFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_ranking, container, false);

        ArrayList<Rank> rankList = new ArrayList<>();
        rankList.add(new Rank(R.drawable.profile_rank1, "doitdoit", 53000));
        rankList.add(new Rank(R.drawable.profile_rank2, "dowhatyoulike", 49400));
        rankList.add(new Rank(R.drawable.profile_rank3, "godoit837", 42600));
        rankList.add(new Rank(R.drawable.profile_rank4, "gkwkgo", 39800));
        rankList.add(new Rank(R.drawable.profile_rank1, "cancan", 33000));
        rankList.add(new Rank(R.drawable.profile_rank2, "betme", 31000));
        rankList.add(new Rank(R.drawable.profile_rank1, "doitdoit", 53000));
        rankList.add(new Rank(R.drawable.profile_rank2, "dowhatyoulike", 49400));
        rankList.add(new Rank(R.drawable.profile_rank3, "godoit837", 42600));
        rankList.add(new Rank(R.drawable.profile_rank4, "gkwkgo", 39800));
        rankList.add(new Rank(R.drawable.profile_rank1, "cancan", 33000));
        rankList.add(new Rank(R.drawable.profile_rank2, "betme", 31000));


        RankAdapter rankAdapter = new RankAdapter(rankList, view.getContext(), R.layout.item_rank);

        ListView rankListView = (ListView) view.findViewById(R.id.rank_list_view);
        rankListView.setAdapter(rankAdapter);



        return view;
    }




}

