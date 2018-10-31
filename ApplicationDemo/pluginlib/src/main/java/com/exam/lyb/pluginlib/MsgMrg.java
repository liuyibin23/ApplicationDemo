package com.exam.lyb.pluginlib;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * Create By lyb on 2018/10/29
 **/
public class MsgMrg extends IMsgInterface.Stub {
    @Override
    public void onMsgReceive(String msg) throws RemoteException {
        Log.d("MsgMrg",msg);
    }

}
