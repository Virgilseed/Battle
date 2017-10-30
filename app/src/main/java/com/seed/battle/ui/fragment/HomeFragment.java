package com.seed.battle.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.seed.battle.R;
import com.seed.battle.ui.BaseFragment;
import com.seed.battle.ui.widget.toolbar.CommonToolBar;
import com.seed.battle.ui.widget.toolbar.CommonToolbarListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {
    @Bind(R.id.toolbar)
    CommonToolBar toolbar;
    @Bind(R.id.home_tablayout)
    TabLayout mTablayout;
    @Bind(R.id.home_viewpager)
    ViewPager mViewpager;

    private List<BaseFragment> mFragmentList;
    private String[] mTitleArray = {"最新", "资讯", "娱乐", "主宰", "攻略"};

    public static HomeFragment newInstance(String param1, String param2) {
        return new HomeFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < mTitleArray.length; i++) {
            HomeListFragment homeListFragment = HomeListFragment.newInstance(mTitleArray[i], i + 1);
            mFragmentList.add(homeListFragment);
        }
    }

    @Override
    protected void initView() {
        toolbar.closeLeftImageView();
        toolbar.replaceRightImageView(R.mipmap.search_alpha_icon);
        toolbar.showRightImageView();
        mTablayout.setTabTextColors(ContextCompat.getColor(getContext(), R.color.gray), ContextCompat.getColor(getContext(), R.color.white));
        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTablayout.setupWithViewPager(mViewpager, true);
        mViewpager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public int getCount() {
                return mTitleArray.length;
            }

            @Override
            public Fragment getItem(int position) {
                  return mFragmentList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitleArray[position];
            }
        });
    }

    @Override
    protected void initEvent() {
        toolbar.setmListener(new CommonToolbarListener() {
            @Override
            public boolean onLeftImageListener() {
                return false;
            }

            @Override
            public boolean onRightImageListener() {
                //搜索
                return false;
            }

            @Override
            public boolean onLeftTextListener() {
                return false;
            }

            @Override
            public boolean onRightTextListener() {
                return false;
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
