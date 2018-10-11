package com.superc.common.widget.demo.qmuitest;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.superc.common.widget.demo.qmuitest.manager.QDUpgradeManager;

/**
 * Demo 的 Application 入口。
 * Created by cgine on 16/3/22.
 */
public class QDApplication extends Application {

    @SuppressLint("StaticFieldLeak") private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);

        QDUpgradeManager.getInstance(this).check();
    }
}
