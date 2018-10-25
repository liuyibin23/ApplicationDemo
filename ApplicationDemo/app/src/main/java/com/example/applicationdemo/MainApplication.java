package com.example.applicationdemo;

import com.example.utils.AccountMrgImpl;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginApplication;
import com.qihoo360.replugin.RePluginConfig;

/**
 * Create By lyb on 2018/10/24
 **/
public class MainApplication extends RePluginApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        RePlugin.enableDebugger(this, BuildConfig.DEBUG);
        RePlugin.registerGlobalBinder("host",new AccountMrgImpl());
    }

    @Override
    protected RePluginConfig createConfig() {
        RePluginConfig c = new RePluginConfig();
        //RePlugin默认会对安装的外置插件进行签名校验，这里先关掉，避免调试时出现签名错误
        c.setVerifySign(false);
        return c;
    }
}
