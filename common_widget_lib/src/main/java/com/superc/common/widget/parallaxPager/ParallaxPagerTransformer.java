package com.superc.common.widget.parallaxPager;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * 镜子效果，可以使用到ViewPager上
 * ViewPager mPager;
 * FragmentStatePagerAdapter mAdapter;
 * <p>
 * public void onCreate(Bundle savedInstanceState) {
 * mPager = (ViewPager) findViewById(R.id.pager);
 * // creating the parallaxTransformer, you only need to pass the id of the View (or ViewGroup) you want to do the parallax effect
 * mPager.setPageTransformer(false, new ParallaxPagerTransformer(R.id.parallaxContent));
 * mAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager());
 * mAdapter.setPager(mPager);
 * <p>
 * }
 */
public class ParallaxPagerTransformer implements ViewPager.PageTransformer {

    private int id;
    private int border = 0;
    private float speed = 0.2f;

    public ParallaxPagerTransformer(int id) {
        this.id = id;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void transformPage(View view, float position) {

        View parallaxView = view.findViewById(id);

        if (view == null) {
            Log.w("ParallaxPager", "There is no view");
        }

        if (parallaxView != null && Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            if (position > -1 && position < 1) {
                float width = parallaxView.getWidth();
                parallaxView.setTranslationX(-(position * width * speed));
                float sc = ((float) view.getWidth() - border) / view.getWidth();
                if (position == 0) {
                    view.setScaleX(1);
                    view.setScaleY(1);
                } else {
                    view.setScaleX(sc);
                    view.setScaleY(sc);
                }
            }
        }
    }

    public void setBorder(int px) {
        border = px;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}