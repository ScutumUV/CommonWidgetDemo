package com.superc.common.widget.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.superc.common.widget.secretTextView.SecretTextView;

public class SecretTextViewTestActivity extends AppCompatActivity {
    SecretTextView secretTextView;

    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_text_view_test);

        secretTextView = (SecretTextView) findViewById(R.id.textview);
        secretTextView.setDuration(3000);
        secretTextView.setIsVisible(true);
        secretTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secretTextView.toggle();
            }
        });

        change = (Button) findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secretTextView.setText("This is really an amazing TextView");
            }
        });
    }
}
