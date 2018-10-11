package com.superc.common.widget.demo.qmuitest.fragment.components.qqface.pageView;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.superc.common.widget.demo.R;
import com.superc.common.widget.demo.qmuitest.fragment.components.qqface.QDQQFaceTestData;
import com.superc.common.widget.qmui.link.QMUIScrollingMovementMethod;
import com.superc.common.widget.qmui.util.QMUIDisplayHelper;

/**
 * @author cginechen
 * @date 2017-06-08
 */
public abstract class QDQQFaceBasePagerView extends LinearLayout {
    private TextView mLogTv;

    private QDQQFaceTestData mTestData;

    public QDQQFaceBasePagerView(Context context) {
        super(context);

        mTestData = new QDQQFaceTestData();

        setOrientation(VERTICAL);
        ListView listView = new ListView(context);
        LayoutParams listLp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        listLp.weight = 1;
        listView.setLayoutParams(listLp);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setAdapter(new MyAdapter());
        addView(listView);

        mLogTv = new TextView(context);
        LayoutParams logLp = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, QMUIDisplayHelper.dp2px(context, 60));
        mLogTv.setLayoutParams(logLp);
        mLogTv.setTextSize(12);
        mLogTv.setBackgroundResource(R.drawable.qmui_divider_top_bitmap);
        int paddingHor = QMUIDisplayHelper.dp2px(context, 16);
        mLogTv.setPadding(paddingHor, 0, paddingHor, 0);
        mLogTv.setTextColor(ContextCompat.getColor(context, R.color.qmui_config_color_black));
        mLogTv.setMovementMethod(QMUIScrollingMovementMethod.getInstance());
        addView(mLogTv);
    }

    protected CharSequence getItem(int position) {
        return mTestData.getList().get(position);
    }

    private void refreshLogView(String msg) {
        mLogTv.append(msg);
        int offset = mLogTv.getLineCount() * mLogTv.getLineHeight();
        if (offset > mLogTv.getHeight()) {
            mLogTv.scrollTo(0, offset - mLogTv.getHeight());
        }
    }

    protected abstract View getView(int position, View convertView, ViewGroup parent);

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mTestData.getList().size();
        }

        @Override
        public CharSequence getItem(int position) {
            return mTestData.getList().get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            long start = System.currentTimeMillis();
            convertView = QDQQFaceBasePagerView.this.getView(position, convertView, parent);
            long end = System.currentTimeMillis();
            refreshLogView("getView : position = " + position + "; expend time = " + (end - start) + " \n");
            return convertView;
        }
    }
}
