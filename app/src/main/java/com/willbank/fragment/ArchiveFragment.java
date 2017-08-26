package com.willbank.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.willbank.R;
import com.willbank.adapter.ArchiveAdapter;
import com.willbank.instance.Archive;

import java.util.ArrayList;


public class ArchiveFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_archive, container, false);

        ArrayList<Archive> archiveList = new ArrayList<>();

        archiveList.add(new Archive(R.drawable.archive1, "31일동안\n하루 커피\n한잔 값 저금하기", "한진경", 50000));
        archiveList.add(new Archive(R.drawable.archive2, "100일동안\n10kg 감량하기", "윤진하", 200000));
        archiveList.add(new Archive(R.drawable.archive1, "31일동안\n하루 커피\n한잔 값 저금하기", "한진경", 50000));
        archiveList.add(new Archive(R.drawable.archive2, "100일동안\n10kg 감량하기", "윤진하", 200000));
        archiveList.add(new Archive(R.drawable.archive1, "31일동안\n하루 커피\n한잔 값 저금하기", "한진경", 50000));
        archiveList.add(new Archive(R.drawable.archive2, "100일동안\n10kg 감량하기", "윤진하", 200000));

        ArchiveAdapter archiveAdapter = new ArchiveAdapter(archiveList, getContext(), R.layout.item_archive);

        ListView archiveView = (ListView) view.findViewById(R.id.archive_list_view);
        archiveView.setAdapter(archiveAdapter);


        return view;
    }




}

