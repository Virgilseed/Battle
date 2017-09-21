package com.seed.battle.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seed.battle.R;
import com.seed.battle.ui.BaseFragment;


public class VideoFragment extends BaseFragment{

    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment baseFragment = new VideoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", param1);
        bundle.putString("param2", param2);
        baseFragment.setArguments(bundle);
        return baseFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_video, container, false);
        return view;
    }

}
