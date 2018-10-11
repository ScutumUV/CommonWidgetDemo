package com.superc.common.widget.demo.qmuitest.manager;

import com.superc.common.widget.demo.qmuitest.base.BaseFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDBottomSheetFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDButtonFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDCollapsingTopBarLayoutFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDDialogFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDEmptyViewFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDFloatLayoutFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDGroupListViewFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDLayoutFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDLinkTextViewFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDPopupFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDPriorityLinearLayoutFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDProgressBarFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDPullRefreshFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDRadiusImageViewFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDSpanTouchFixTextViewFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDTabSegmentFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDTipDialogFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.QDVerticalTextViewFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.qqface.QDQQFaceFragment;
import com.superc.common.widget.demo.qmuitest.fragment.components.viewpager.QDViewPagerFragment;
import com.superc.common.widget.demo.qmuitest.fragment.lab.QDAnimationListViewFragment;
import com.superc.common.widget.demo.qmuitest.fragment.lab.QDArchTestFragment;
import com.superc.common.widget.demo.qmuitest.fragment.lab.QDSnapHelperFragment;
import com.superc.common.widget.demo.qmuitest.fragment.util.QDColorHelperFragment;
import com.superc.common.widget.demo.qmuitest.fragment.util.QDDeviceHelperFragment;
import com.superc.common.widget.demo.qmuitest.fragment.util.QDDrawableHelperFragment;
import com.superc.common.widget.demo.qmuitest.fragment.util.QDNotchHelperFragment;
import com.superc.common.widget.demo.qmuitest.fragment.util.QDSpanFragment;
import com.superc.common.widget.demo.qmuitest.fragment.util.QDStatusBarHelperFragment;
import com.superc.common.widget.demo.qmuitest.fragment.util.QDViewHelperFragment;
import com.superc.common.widget.demo.qmuitest.model.QDItemDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cginechen
 * @date 2016-10-21
 */

public class QDDataManager {
    private static QDDataManager _sInstance;
    private QDWidgetContainer mWidgetContainer;

    private List<Class<? extends BaseFragment>> mComponentsNames;
    private List<Class<? extends BaseFragment>> mUtilNames;
    private List<Class<? extends BaseFragment>> mLabNames;

    public QDDataManager() {
        mWidgetContainer = QDWidgetContainer.getInstance();
        initComponentsDesc();
        initUtilDesc();
        initLabDesc();
    }

    public static QDDataManager getInstance() {
        if (_sInstance == null) {
            _sInstance = new QDDataManager();
        }
        return _sInstance;
    }


    /**
     * Components
     */
    private void initComponentsDesc() {
        mComponentsNames = new ArrayList<>();
        mComponentsNames.add(QDButtonFragment.class);
        mComponentsNames.add(QDDialogFragment.class);
        mComponentsNames.add(QDFloatLayoutFragment.class);
        mComponentsNames.add(QDEmptyViewFragment.class);
        mComponentsNames.add(QDTabSegmentFragment.class);
        mComponentsNames.add(QDProgressBarFragment.class);
        mComponentsNames.add(QDBottomSheetFragment.class);
        mComponentsNames.add(QDGroupListViewFragment.class);
        mComponentsNames.add(QDTipDialogFragment.class);
        mComponentsNames.add(QDRadiusImageViewFragment.class);
        mComponentsNames.add(QDVerticalTextViewFragment.class);
        mComponentsNames.add(QDPullRefreshFragment.class);
        mComponentsNames.add(QDPopupFragment.class);
        mComponentsNames.add(QDSpanTouchFixTextViewFragment.class);
        mComponentsNames.add(QDLinkTextViewFragment.class);
        mComponentsNames.add(QDQQFaceFragment.class);
        mComponentsNames.add(QDSpanFragment.class);
        mComponentsNames.add(QDCollapsingTopBarLayoutFragment.class);
        mComponentsNames.add(QDViewPagerFragment.class);
        mComponentsNames.add(QDLayoutFragment.class);
        mComponentsNames.add(QDPriorityLinearLayoutFragment.class);
    }

    /**
     * Helper
     */
    private void initUtilDesc() {
        mUtilNames = new ArrayList<>();
        mUtilNames.add(QDColorHelperFragment.class);
        mUtilNames.add(QDDeviceHelperFragment.class);
        mUtilNames.add(QDDrawableHelperFragment.class);
        mUtilNames.add(QDStatusBarHelperFragment.class);
        mUtilNames.add(QDViewHelperFragment.class);
        mUtilNames.add(QDNotchHelperFragment.class);
    }

    /**
     * Lab
     */
    private void initLabDesc() {
        mLabNames = new ArrayList<>();
        mLabNames.add(QDAnimationListViewFragment.class);
        mLabNames.add(QDSnapHelperFragment.class);
        mLabNames.add(QDArchTestFragment.class);
    }

    public QDItemDescription getDescription(Class<? extends BaseFragment> cls) {
        return mWidgetContainer.get(cls);
    }

    public String getName(Class<? extends BaseFragment> cls) {
        QDItemDescription itemDescription = getDescription(cls);
        if (itemDescription == null) {
            return null;
        }
        return itemDescription.getName();
    }

    public List<QDItemDescription> getComponentsDescriptions() {
        List<QDItemDescription> list = new ArrayList<>();
        for (int i = 0; i < mComponentsNames.size(); i++) {
            list.add(mWidgetContainer.get(mComponentsNames.get(i)));
        }
        return list;
    }

    public List<QDItemDescription> getUtilDescriptions() {
        List<QDItemDescription> list = new ArrayList<>();
        for (int i = 0; i < mUtilNames.size(); i++) {
            list.add(mWidgetContainer.get(mUtilNames.get(i)));
        }
        return list;
    }

    public List<QDItemDescription> getLabDescriptions() {
        List<QDItemDescription> list = new ArrayList<>();
        for (int i = 0; i < mLabNames.size(); i++) {
            list.add(mWidgetContainer.get(mLabNames.get(i)));
        }
        return list;
    }
}
