package com.superc.common.widget.demo.qmuitest.base;

import com.superc.common.arch.QMUIFragment;
import com.superc.common.widget.demo.qmuitest.manager.QDUpgradeManager;
import com.superc.common.widget.qmui.util.QMUIDisplayHelper;

/**
 * Created by cgspine on 2018/1/7.
 */
public abstract class BaseFragment extends QMUIFragment {


    public BaseFragment() {
    }

    @Override
    protected int backViewInitOffset() {
        return QMUIDisplayHelper.dp2px(getContext(), 100);
    }

    @Override
    public void onResume() {
        super.onResume();
        QDUpgradeManager.getInstance(getContext()).runUpgradeTipTaskIfExist(getActivity());

    }

}
