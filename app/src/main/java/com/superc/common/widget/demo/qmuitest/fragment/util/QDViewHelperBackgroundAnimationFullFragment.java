package com.superc.common.widget.demo.qmuitest.fragment.util;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.superc.common.widget.demo.R;
import com.superc.common.widget.demo.qmuitest.base.BaseFragment;
import com.superc.common.widget.demo.qmuitest.manager.QDDataManager;
import com.superc.common.widget.qmui.annotation.Group;
import com.superc.common.widget.qmui.annotation.Widget;
import com.superc.common.widget.qmui.util.QMUIViewHelper;
import com.superc.common.widget.qmui.widget.QMUITopBar;
import com.superc.common.widget.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link QMUIViewHelper#playViewBackgroundAnimation(View, int, int, long)} 的使用示例。
 * Created by Kayo on 2017/2/7.
 */
@Widget(group = Group.Other, name = "做背景变化动画")
public class QDViewHelperBackgroundAnimationFullFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.actiontBtn)
    QMUIRoundButton mActionButton;
    @BindView(R.id.container)
    ViewGroup mContainer;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewhelper_background_animation, null);
        ButterKnife.bind(this, root);

        initTopBar();
        initContent();

        return root;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        mTopBar.setTitle(QDDataManager.getInstance().getName(this.getClass()));
    }

    private void initContent() {
        mActionButton.setText("点击后从黄色背景渐变到绿色背景");
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QMUIViewHelper.playViewBackgroundAnimation(mContainer, ContextCompat.getColor(getContext(), R.color.app_color_theme_3), ContextCompat.getColor(getContext(), R.color.app_color_theme_4), 500);
            }
        });
    }
}
