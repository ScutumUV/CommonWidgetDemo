package com.superc.common.widget.demo;

import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

import com.superc.common.widget.shimmer.Shimmer;
import com.superc.common.widget.shimmer.ShimmerTextView;

public class ShimmerViewTestActivity extends AppCompatActivity {

    ShimmerTextView tv;
    Shimmer shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer_view_test);

        tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);
    }

    public void toggleAnimation(View target) {
        if (shimmer != null && shimmer.isAnimating()) {
            shimmer.cancel();
        } else {
            shimmer = new Shimmer();
            shimmer.start(tv);
        }
    }
}
