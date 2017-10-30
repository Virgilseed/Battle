package com.seed.battle.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;


public abstract class BaseFragment extends Fragment {

    protected static String TAG = "BaseFragment";
    private ProgressDialog mProgressDialog;

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initEvent();

//    public static BaseFragment newInstance(String param1, String param2) {
//        BaseFragment baseFragment = new BaseFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("param1", param1);
//        bundle.putString("param2", param2);
//        baseFragment.setArguments(bundle);
//        return baseFragment;
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            TAG = getClass().getSimpleName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected boolean showLoading() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(getContext());
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
        return false;
    }

    protected boolean dismissLoading() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(getContext());
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        return false;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    protected void showToast(String content, int duration) {
        try {
            if (TextUtils.isEmpty(content)) {
                return;
            }
            Toast.makeText(getContext(), content, duration).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showToast(String content) {
        try {
            if (TextUtils.isEmpty(content)) {
                return;
            }
            Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
