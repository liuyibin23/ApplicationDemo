package com.example.lyb.plugindemo1.utils;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

public class MsgDemo1Imp extends IMsgDemo1.Stub {

    private RemoteCallbackList<IOnMsgArrivedListener> mListenerList = new RemoteCallbackList<>();

    @Override
    public void onMsgReceived(String msg) throws RemoteException {
        Log.d("MsgDemo1Imp","onMsgReceived");
        final int n = mListenerList.beginBroadcast();
        for (int i = 0; i<n;i++){
            IOnMsgArrivedListener l = mListenerList.getBroadcastItem(i);
            if(l != null){
                l.onMsgArrived(msg);
            }
        }
        mListenerList.finishBroadcast();
    }

    @Override
    public void registerListener(IOnMsgArrivedListener listener) throws RemoteException {
        mListenerList.register(listener);
    }

    @Override
    public void unregisterListener(IOnMsgArrivedListener listener) throws RemoteException {
        mListenerList.unregister(listener);
    }

    @Override
    public void unregisterAll() throws RemoteException {
        final int n = mListenerList.beginBroadcast();
        for (int i = 0; i<n;i++){
            IOnMsgArrivedListener l = mListenerList.getBroadcastItem(i);
            if(l != null){
                mListenerList.unregister(l);
            }
        }
        mListenerList.finishBroadcast();
    }
}
