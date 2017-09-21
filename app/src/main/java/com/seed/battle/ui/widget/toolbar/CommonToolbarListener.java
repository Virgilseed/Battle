package com.seed.battle.ui.widget.toolbar;


public interface CommonToolbarListener {
    /**
     * 左边图片监听事件
     * @return
     */
    boolean onLeftImageListener();

    /**
     * 右边图片监听事件
     * @return
     */
    boolean onRightImageListener();

    /**
     * 左边文字监听事件
     * @return
     */
    boolean onLeftTextListener();

    /**
     * 右边文字监听事件
     * @return
     */
    boolean onRightTextListener();
}
