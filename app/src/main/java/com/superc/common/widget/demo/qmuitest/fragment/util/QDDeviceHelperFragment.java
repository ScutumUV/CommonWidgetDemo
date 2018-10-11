package com.superc.common.widget.demo.qmuitest.fragment.util;

import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;

import com.superc.common.widget.demo.R;
import com.superc.common.widget.demo.qmuitest.base.BaseFragment;
import com.superc.common.widget.demo.qmuitest.manager.QDDataManager;
import com.superc.common.widget.demo.qmuitest.model.QDItemDescription;
import com.superc.common.widget.qmui.annotation.Group;
import com.superc.common.widget.qmui.annotation.Widget;
import com.superc.common.widget.qmui.util.QMUIDeviceHelper;
import com.superc.common.widget.qmui.util.QMUIDisplayHelper;
import com.superc.common.widget.qmui.util.QMUIKeyboardHelper;
import com.superc.common.widget.qmui.util.QMUIResHelper;
import com.superc.common.widget.qmui.util.QMUIViewHelper;
import com.superc.common.widget.qmui.widget.QMUITopBarLayout;
import com.superc.common.widget.qmui.widget.dialog.QMUIBottomSheet;
import com.superc.common.widget.qmui.widget.dialog.QMUIDialog;
import com.superc.common.widget.qmui.widget.dialog.QMUIDialogAction;
import com.superc.common.widget.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link QMUIDeviceHelper} 的使用示例。
 * Created by Kayo on 2016/12/2.
 */

@Widget(group = Group.Helper, widgetClass = QMUIDeviceHelper.class, iconRes = R.mipmap.icon_grid_device_helper)
public class QDDeviceHelperFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBar;
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;

    private QDItemDescription mQDItemDescription;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_grouplistview, null);
        ButterKnife.bind(this, root);

        mQDItemDescription = QDDataManager.getInstance().getDescription(this.getClass());
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

        mTopBar.setTitle(mQDItemDescription.getName());
    }

    private SpannableString getFormatItemValue(CharSequence value) {
        SpannableString result = new SpannableString(value);
        result.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.qmui_config_color_gray_5)), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return result;
    }

    private void initContent() {
        String isTabletText = booleanToString(QMUIDeviceHelper.isTablet(getContext()));
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(getString(R.string.deviceHelper_tablet_title)), null)
                .addItemView(mGroupListView.createItemView(getFormatItemValue(String.format("当前设备%1$s平板设备", isTabletText))), null)
                .addTo(mGroupListView);

        String isFlymeText = booleanToString(QMUIDeviceHelper.isFlyme());
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(getString(R.string.deviceHelper_flyme_title)), null)
                .addItemView(mGroupListView.createItemView(getFormatItemValue(String.format("当前设备%1$s Flyme 系统", isFlymeText))), null)
                .addTo(mGroupListView);

        String isMiuiText = booleanToString(QMUIDeviceHelper.isMIUI());
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(getString(R.string.deviceHelper_miui_title)), null)
                .addItemView(mGroupListView.createItemView(getFormatItemValue(String.format("当前设备%1$s MIUI 系统", isMiuiText))), null)
                .addTo(mGroupListView);

        String isMeizuText = booleanToString(QMUIDeviceHelper.isMeizu());
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(getString(R.string.deviceHelper_meizu_title)), null)
                .addItemView(mGroupListView.createItemView(getFormatItemValue(String.format("当前设备%1$s魅族手机", isMeizuText))), null)
                .addTo(mGroupListView);
    }

    private String booleanToString(boolean b) {
        return b ? "是" : "不是";
    }
}
