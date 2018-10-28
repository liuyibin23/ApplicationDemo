package com.example.utils;

import android.os.RemoteException;

/**
 * Create By lyb on 2018/10/25
 **/
public class AccountMrgImpl extends IAccountMrg.Stub {
    @Override
    public String getCurrentUserInfo() throws RemoteException {
        return AccountManager.getInstance().getCurrentUserInfoJson();
    }

    @Override
    public void setCurrentUserName(String name) throws RemoteException {
        AccountManager.getInstance().getCurrentUserInfo().setUsername(name);
    }
}
