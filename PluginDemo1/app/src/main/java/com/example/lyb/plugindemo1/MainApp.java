package com.example.lyb.plugindemo1;

import android.app.Application;

import com.example.lyb.plugindemo1.utils.MsgDemo1Imp;
import com.qihoo360.replugin.RePlugin;

public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RePlugin.registerPluginBinder("plugindemo1",new MsgDemo1Imp());
    }
}
