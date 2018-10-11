package com.superc.common.widget.demo.qmuitest.fragment.components;

import android.view.LayoutInflater;
import android.view.View;

import com.superc.common.widget.demo.R;
import com.superc.common.widget.demo.qmuitest.base.BaseFragment;
import com.superc.common.widget.demo.qmuitest.manager.QDDataManager;
import com.superc.common.widget.qmui.annotation.Widget;
import com.superc.common.widget.qmui.layout.QMUIPriorityLinearLayout;
import com.superc.common.widget.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

@Widget(widgetClass = QMUIPriorityLinearLayout.class, iconRes = R.mipmap.icon_grid_float_layout)
public class QDPriorityLinearLayoutFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBar;

    public QDPriorityLinearLayoutFragment() {
    }

    @Override
    protected View onCreateView() {
        View rootView = LayoutInflater.from(getContext()).inflate(
                R.layout.fragment_priority_linear_layout, null);
        ButterKnife.bind(this, rootView);
        initTopBar();
        return rootView;
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
}

