package com.exam.lyb.plugindemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qihoo360.replugin.loader.a.PluginAppCompatActivity;

public class MainActivity extends PluginAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
