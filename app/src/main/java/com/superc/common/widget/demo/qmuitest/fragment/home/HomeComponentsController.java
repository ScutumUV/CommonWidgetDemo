package com.superc.common.widget.demo.qmuitest.fragment.home;

import android.content.Context;

import com.superc.common.widget.demo.qmuitest.manager.QDDataManager;

import static com.superc.common.widget.demo.application.MyApplication.getContext;

/**
 * @author cginechen
 * @date 2016-10-20
 */

public class HomeComponentsController extends HomeController {

    public HomeComponentsController(Context context) {
        super(context);
    }

    @Override
    protected String getTitle() {
        return "Components";
    }

    @Override
    protected ItemAdapter getItemAdapter() {
        return new ItemAdapter(getContext(), QDDataManager.getInstance().getComponentsDescriptions());
    }
}
