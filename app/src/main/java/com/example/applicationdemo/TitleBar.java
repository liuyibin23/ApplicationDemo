package com.example.applicationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by 刘乙镔 on 2017/3/12.
 */

public class TitleBar extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        final boolean customTitleSupported =
                requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        if (customTitleSupported) {
            getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
                    R.layout.titlebar);
        }
        final TextView myTitleText = (TextView) findViewById(R.id.myTitle);
        if (myTitleText != null) {
            myTitleText.setText("NEW TITLE");
            // user can also set color using "Color" and then
            // "Color value constant"
            // myTitleText.setBackgroundColor(Color.GREEN);
        }
    }
}
