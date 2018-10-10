package com.superc.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * 任意位置弹出框View
 */
public class DropView extends LinearLayout {

    //底部容器，包含popupMenuViews，maskView
    protected FrameLayout containerView;
    //弹出菜单父布局
    protected FrameLayout popupMenuViews;
    //遮罩半透明View，点击可关闭DropView
    protected View maskView;
    //遮罩颜色 默认半透明
    protected int maskColor = 0x7f000000;
    //加入的View
    protected View mChildView;

    protected boolean isShown = false;

    protected boolean isInit = false;

    protected OnDropViewStatusCallBack callBack;

    public DropView(Context context) {
        this(context, null);
    }

    public DropView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    protected void init(Context context, AttributeSet attrs) {
        //初始化containerView并将其添加到DropDownMenu
        containerView = new FrameLayout(context);
        if (null != attrs) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DropView);
            mChildView = LayoutInflater.from(getContext()).inflate(
                    array.getResourceId(R.styleable.DropView_tViewResId, 0), null
            );
            final int back = array.getResourceId(R.styleable.DropView_tBackground, 0);
            if (0 != back) {
                containerView.setBackgroundResource(back);
            }
            array.recycle();
        }
        containerView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        addView(containerView, 0);
        if (null != mChildView) {
            setDropView(mChildView);
        }
    }

    public void setDropView(@NonNull View view) {
        maskView = new View(getContext());
        maskView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        maskView.setBackgroundColor(maskColor);
        maskView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        containerView.addView(maskView, 0);
        maskView.setVisibility(GONE);
        popupMenuViews = new FrameLayout(getContext());
        popupMenuViews.setVisibility(GONE);
        containerView.addView(popupMenuViews, 1);
        popupMenuViews.addView(view, 0);
        isInit = true;
    }

    public void open() {
        checkInItStatus();
        popupMenuViews.setVisibility(View.VISIBLE);
//        popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_in));
        popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bottom_in));
        maskView.setVisibility(VISIBLE);
        maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_in));
        popupMenuViews.getChildAt(0).setVisibility(View.VISIBLE);
        isShown = true;
        callBack();
    }

    public void close() {
        checkInItStatus();
        popupMenuViews.setVisibility(View.GONE);
//        popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_out));
        popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bottom_out));
        maskView.setVisibility(GONE);
        maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_out));
        isShown = false;
        callBack();
    }

    void callBack() {
        if (callBack != null) {
            callBack.onStatus(this, isShown);
        }
    }

    void checkInItStatus() {
        if (!isInit) {
            throw new IllegalArgumentException("The DropView must use after init");
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        isInit = false;
    }

    public OnDropViewStatusCallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(OnDropViewStatusCallBack callBack) {
        this.callBack = callBack;
    }

    public int getMaskColor() {
        return maskColor;
    }

    public void setMaskColor(int maskColor) {
        this.maskColor = maskColor;
    }

    @Override
    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    public boolean isInit() {
        return isInit;
    }

    public void setInit(boolean init) {
        isInit = init;
    }

    public interface OnDropViewStatusCallBack {
        void onStatus(DropView view, boolean isOpen);
    }
}
