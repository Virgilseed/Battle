package com.seed.battle.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seed.battle.R;
import com.seed.battle.ui.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Water on 2017/10/30.
 */

public class HomeListFragment extends BaseFragment {
    @Bind(R.id.home_list_test)
    TextView mListTest;
    private String mTitle = "";
    private int mType = 1;


    public static HomeListFragment newInstance(String param1, int param2) {
        HomeListFragment baseFragment = new HomeListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", param1);
        bundle.putInt("param2", param2);
        baseFragment.setArguments(bundle);
        return baseFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            mTitle = getArguments().getString("param1", "");
            mType = getArguments().getInt("param2", 0);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mListTest.setText(mTitle);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
