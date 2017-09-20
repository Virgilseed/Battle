package com.seed.battle.ui.widget.toolbar;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiju.ecbao.R;
import com.aiju.ecbao.utils.StringUtil;


/**
 * Created by Administrator on 2016/1/19.
 */
public class CommonToolBar extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private View mLayout;
    public TextView titleView;
    private TextView leftTextView, rightTextView;
    private ImageView leftImageView, rightImageView;
    private RelativeLayout naviView;
    public ImageView titleDrawable;
    private AnimationDrawable titleLoadingAnim;


    private CommonToolbarListener mListener;

    public CommonToolBar(Context context) {
        super(context);
        this.mContext = context;
        initView();

    }

    public CommonToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }



    public CommonToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mLayout = inflater.inflate(R.layout.view_common_navi, this, true);

        naviView = (RelativeLayout) findViewById(R.id.ec_common_navi);
        titleView = (TextView) findViewById(R.id.ec_common_navi_title);
        leftImageView = (ImageView) findViewById(R.id.ec_common_left_back);
        leftImageView.setOnClickListener(this);
        rightImageView = (ImageView) findViewById(R.id.ec_common_right_back);
        rightImageView.setOnClickListener(this);
        leftTextView = (TextView) findViewById(R.id.ec_common_navi_left);
        leftTextView.setOnClickListener(this);
        rightTextView = (TextView) findViewById(R.id.ec_common_navi_right);
        rightTextView.setOnClickListener(this);

        titleDrawable = (ImageView) findViewById(R.id.ec_common_title_progress);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ec_common_left_back:
                if (mListener != null)
                    mListener.onLeftImageListener();
                break;
            case R.id.ec_common_right_back:
                if (mListener != null)
                    mListener.onRightImageListener();
                break;
            case R.id.ec_common_navi_left:
                if (mListener != null)
                    mListener.onLeftTextListener();
                break;
            case R.id.ec_common_navi_right:
                if (mListener != null)
                    mListener.onRightTextListener();
                break;
        }
    }


    public CommonToolbarListener getmListener() {
        return mListener;
    }

    public void setmListener(CommonToolbarListener mListener) {
        this.mListener = mListener;
    }

    /**
     * 设置标题右边loading
     * @param image
     */
    public void setTitleLoadingDrawable(int image)
    {
        if (titleDrawable.getBackground() == null)
            titleDrawable.setBackgroundResource(image);
        titleDrawable.setVisibility(View.VISIBLE);
    }

    /**
     * 显示标题右边loading
     */
    public void showTitleDrawable()
    {
        titleDrawable.setVisibility(View.VISIBLE);
    }

    /**
     * 开始loading动画
     */
    public void startLoading()
    {
        showTitleDrawable();
        if (titleLoadingAnim == null)
        {
            titleLoadingAnim = (AnimationDrawable) titleDrawable.getBackground();
        }
        if (titleLoadingAnim.isRunning())
            return;
        else
            titleLoadingAnim.start();
    }

    /**
     * 判断loading动画是否在进行
     * @return
     */
    public boolean isLoading()
    {
        if (titleLoadingAnim != null && titleLoadingAnim.isRunning())
            return true;
        else
            return false;
    }

    /**
     * 关闭loading动画
     */
    public void stopLoading()
    {
        titleLoadingAnim.stop();
        closeTitleDrawable();
    }

    /**
     * 关闭标题右边loading
     */
    public void closeTitleDrawable()
    {
        titleDrawable.setVisibility(View.GONE);
    }

    /**
     * 设置标题栏背景颜色
     * @param corlor
     */
    public void setNaviBg(int corlor)
    {
        naviView.setBackgroundColor(corlor);
    }


    /**
     * 设置界面标题
     */
    public void setTitle(String title) {
        if (titleView != null && title != null && !title.equals(""))
            titleView.setText(title);
    }

    /**
     * 设置标题栏颜色
     * @param corlor
     */
    public void setLeftTextViewBg(int corlor)
    {
        leftTextView.setTextColor(corlor);
    }

    /**
     * 显示左边text
     */
    public void showLeftTextView() {
        leftTextView.setVisibility(View.VISIBLE);
    }

    /**
     * 关闭左边text
     */
    public void closeLeftTextView() {
        leftTextView.setVisibility(View.GONE);
    }

    /**
     * 设置左边text
     */
    public void setLeftTitle(String title) {
        showLeftTextView();
        leftTextView.setText(StringUtil.textIsNull(title, ""));
    }


    /**
     * 显示右边text
     */
    public void showRightTextView() {
        rightTextView.setVisibility(View.VISIBLE);
    }

    /**
     * 关闭右边text
     */
    public void closeRightTextView() {
        rightTextView.setVisibility(View.GONE);
    }

    /**
     * 设置右边text
     */
    public void setrightTitle(String title) {
        showRightTextView();
        rightTextView.setText(StringUtil.textIsNull(title, ""));
    }


    /**
     * 显示左边图标
     */
    public void showLeftImageView() {
        leftImageView.setVisibility(View.VISIBLE);
    }

    /**
     * 关闭左边图标
     */
    public void closeLeftImageView() {
        leftImageView.setVisibility(View.GONE);
    }

    /**
     * 得到左边图标View
     */
    public View getLeftImageView() {
        return leftImageView;
    }


    /**
     * 替换右边图标
     */
    public void replaceLeftImageView(int  res) {
        leftImageView.setImageResource(res);
    }

    /**
     * 显示右边图标
     */
    public void showRightImageView() {
        rightImageView.setVisibility(View.VISIBLE);
    }

    /**
     * 关闭右边图标
     */
    public void closeRightImageView() {
        rightImageView.setVisibility(View.INVISIBLE);
    }

    /**
     * 替换右边图标
     */
    public void replaceRightImageView(int  res) {
        rightImageView.setImageResource(res);
    }

    /**
     * 关闭标题栏
     */
    public void closeNavi() {
        naviView.setVisibility(View.GONE);
    }

    /**
     * 打开标题栏
     */
    public void openNavi() {
        naviView.setVisibility(View.VISIBLE);
    }
    /**
     * 设置标题栏透明度
     */
    public void setNaviApla(int alpha) {
        naviView.getBackground().setAlpha(alpha);
    }

    public RelativeLayout getNaviView()
    {
        return naviView;
    }
}
