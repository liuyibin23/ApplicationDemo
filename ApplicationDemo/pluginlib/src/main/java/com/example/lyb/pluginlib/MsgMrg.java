package com.example.lyb.pluginlib;

import android.os.RemoteException;
import android.util.Log;

public class MsgMrg extends IMsgInterface.Stub {
    @Override
    public void onMsgReceive(String msg) throws RemoteException {
        Log.d("MsgMrg",msg);
    }
}
