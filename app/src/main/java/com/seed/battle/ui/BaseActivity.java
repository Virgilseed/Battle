package com.seed.battle.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.widget.Toast;

import butterknife.ButterKnife;


public class BaseActivity extends FragmentActivity {
    protected static String TAG = "BaseActivity";
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataTag();
    }

    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }



    private void initDataTag() {
        TAG = getClass().getSimpleName();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected boolean showLoading() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
        return false;
    }

    protected boolean dismissLoading() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        return false;
    }



    protected void showToast(String content, int duration) {
        try {
            if (TextUtils.isEmpty(content)) {
                return;
            }
            Toast.makeText(this, content, duration).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showToast(String content) {
        try {
            if (TextUtils.isEmpty(content)) {
                return;
            }
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchFragmentForReplace(int layoutId, BaseFragment fragment) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(layoutId, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showFragment(int layoutId, BaseFragment fragment) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(layoutId, fragment).show(fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
