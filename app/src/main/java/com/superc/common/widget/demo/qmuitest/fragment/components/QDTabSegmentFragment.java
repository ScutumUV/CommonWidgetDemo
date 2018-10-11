package com.superc.common.widget.demo.qmuitest.fragment.components;

import android.view.LayoutInflater;
import android.view.View;

import com.superc.common.widget.demo.R;
import com.superc.common.widget.demo.qmuitest.base.BaseFragment;
import com.superc.common.widget.demo.qmuitest.manager.QDDataManager;
import com.superc.common.widget.demo.qmuitest.model.QDItemDescription;
import com.superc.common.widget.qmui.annotation.Widget;
import com.superc.common.widget.qmui.widget.QMUITabSegment;
import com.superc.common.widget.qmui.widget.QMUITopBarLayout;
import com.superc.common.widget.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author cginechen
 * @date 2016-10-21
 */

@Widget(widgetClass = QMUITabSegment.class, iconRes = R.mipmap.icon_grid_tab_segment)
public class QDTabSegmentFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBar;
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;

    private QDDataManager mQDDataManager;
    private QDItemDescription mQDItemDescription;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_grouplistview, null);
        ButterKnife.bind(this, root);

        mQDDataManager = QDDataManager.getInstance();
        mQDItemDescription = mQDDataManager.getDescription(this.getClass());
        initTopBar();

        initGroupListView();

        return root;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        mTopBar.setTitle(mQDItemDescription.getName());
    }

    private void initGroupListView() {
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(mQDDataManager.getName(
                        QDTabSegmentFixModeFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        QDTabSegmentFixModeFragment fragment = new QDTabSegmentFixModeFragment();
                        startFragment(fragment);
                    }
                })
                .addItemView(mGroupListView.createItemView(mQDDataManager.getName(
                        QDTabSegmentScrollableModeFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        QDTabSegmentScrollableModeFragment fragment = new QDTabSegmentScrollableModeFragment();
                        startFragment(fragment);
                    }
                })
                .addTo(mGroupListView);


    }
}
