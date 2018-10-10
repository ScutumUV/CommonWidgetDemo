package com.superc.common.widget.demo.application;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.superc.common.widget.demo.util.CrashHandler;

public class MyApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        CrashHandler.getInstance().init(mContext);
    }

    public static Context getContext() {
        return mContext;
    }
}
