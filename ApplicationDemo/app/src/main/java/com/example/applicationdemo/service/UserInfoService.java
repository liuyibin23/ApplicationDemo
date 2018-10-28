package com.example.applicationdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.utils.AccountManager;
import com.example.utils.AccountMrgImpl;
import com.example.utils.IAccountMrg;

public class UserInfoService extends Service {
    private final String TAG = "UserInfoService";

    private Binder mBinder = new AccountMrgImpl();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("UserInfoService","onCreate");
        AccountManager.getInstance().getCurrentUserInfo().setUsername("serveruser");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("UserInfoService","onBind");
        return mBinder;
    }
}
