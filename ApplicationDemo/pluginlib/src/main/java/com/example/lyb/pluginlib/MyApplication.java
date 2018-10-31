package com.example.lyb.pluginlib;

import android.app.Application;

import com.qihoo360.replugin.RePlugin;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RePlugin.registerPluginBinder("pluginlib",new MsgMrg());
    }
}
