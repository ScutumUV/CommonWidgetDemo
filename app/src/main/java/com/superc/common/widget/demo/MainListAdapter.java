package com.superc.common.widget.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.superc.common.widget.demo.util.AssetsUtil;
import com.superc.common.widget.demo.util.GlideUtil;
import com.superc.common.widget.demo.util.StringUtil;

import java.util.List;

public class MainListAdapter extends BaseAdapter {

    private Context context;
    private List<MainBean> data;

    public MainListAdapter(Context context, List<MainBean> list) {
        this.context = context;
        this.data = list;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public MainBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_main_list, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (null != data) {
            holder.tv.setText(data.get(position).description);
            if (!StringUtil.isEmpty(data.get(position).imageFileName)) {
                if (data.get(position).isGif) {
                    GlideUtil.loadBitmapGif(context, holder.iv, AssetsUtil.getImageFromAssetsFile(data.get(position).imageFileName));
                } else {
                    GlideUtil.loadBitmap(context, holder.iv, AssetsUtil.getImageFromAssetsFile(data.get(position).imageFileName));
                }
            }
        }
        return convertView;
    }

    public static class Holder {
        public ImageView iv;
        public TextView tv;

        public Holder(View v) {
            tv = v.findViewById(R.id.item_tv);
            iv = v.findViewById(R.id.item_iv);
        }
    }
}
