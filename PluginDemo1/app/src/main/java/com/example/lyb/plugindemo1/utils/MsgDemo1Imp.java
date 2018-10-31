package com.example.lyb.plugindemo1.utils;

import android.os.RemoteException;
import android.util.Log;

public class MsgDemo1Imp extends IMsgDemo1.Stub {
    @Override
    public void onMsgReceived(String msg) throws RemoteException {
        Log.d("MsgDemo1Imp","onMsgReceived");
    }
}
