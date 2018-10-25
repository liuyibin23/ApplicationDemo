package com.example.applicationdemo;

import com.example.utils.AccountMrgImpl;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginApplication;

/**
 * Create By lyb on 2018/10/24
 **/
public class MainApplication extends RePluginApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        RePlugin.registerGlobalBinder("host",new AccountMrgImpl());
    }
}
