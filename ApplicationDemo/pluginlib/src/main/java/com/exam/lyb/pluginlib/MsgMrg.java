package com.exam.lyb.pluginlib;

import android.os.IBinder;
import android.os.RemoteException;

/**
 * Create By lyb on 2018/10/29
 **/
public class MsgMrg implements IMsgInterface {
    @Override
    public void onMsgReceive(String msg) throws RemoteException {

    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
