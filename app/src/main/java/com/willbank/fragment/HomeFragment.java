package com.willbank.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.willbank.R;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        //progress bar
        RoundCornerProgressBar progress = (RoundCornerProgressBar) view.findViewById(R.id.progress);
        progress.setProgressColor(Color.parseColor("#ed3b27"));
        progress.setProgressBackgroundColor(Color.parseColor("#808080"));
        progress.setMax(100);
        progress.setProgress(15);

//        int progressColor1 = progress.getProgressColor();
//        int backgroundColor1 = progress.getProgressBackgroundColor();
//        int max1 = (int) progress.getMax();
//        int progress1 = (int) progress.getProgress();

        return view;
    }


}
