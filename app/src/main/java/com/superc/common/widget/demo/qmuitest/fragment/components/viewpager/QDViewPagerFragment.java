package com.superc.common.widget.demo.qmuitest.fragment.components.viewpager;

import android.view.LayoutInflater;
import android.view.View;

import com.superc.common.widget.demo.R;
import com.superc.common.widget.demo.qmuitest.base.BaseFragment;
import com.superc.common.widget.demo.qmuitest.manager.QDDataManager;
import com.superc.common.widget.demo.qmuitest.model.QDItemDescription;
import com.superc.common.widget.qmui.annotation.Widget;
import com.superc.common.widget.qmui.widget.QMUITopBarLayout;
import com.superc.common.widget.qmui.widget.QMUIViewPager;
import com.superc.common.widget.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author cginechen
 * @date 2017-09-13
 */

@Widget(widgetClass = QMUIViewPager.class, iconRes = R.mipmap.icon_grid_pager_layout_manager)
public class QDViewPagerFragment extends BaseFragment {
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
                        QDFitSystemWindowViewPagerFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        QDFitSystemWindowViewPagerFragment fragment = new QDFitSystemWindowViewPagerFragment();
                        startFragment(fragment);
                    }
                })
                .addItemView(mGroupListView.createItemView(mQDDataManager.getName(
                        QDLoopViewPagerFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        QDLoopViewPagerFragment fragment = new QDLoopViewPagerFragment();
                        startFragment(fragment);
                    }
                })
                .addTo(mGroupListView);
    }
}
