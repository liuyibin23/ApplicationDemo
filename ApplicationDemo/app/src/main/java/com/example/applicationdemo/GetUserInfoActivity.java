package com.example.applicationdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.applicationdemo.service.UserInfoService;
import com.example.utils.IAccountMrg;

public class GetUserInfoActivity extends AppCompatActivity {
    private final String TAG = "GetUserInfoActivity";
    private IAccountMrg mAccountMrg;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mAccountMrg = IAccountMrg.Stub.asInterface(service);
//            try {
//                mAccountMrg.setCurrentUserName("helloUser");
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mAccountMrg = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_info);
        Intent intent =  new Intent(this, UserInfoService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
        initView();
    }

    private void initView(){
        findViewById(R.id.btn_get_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d(TAG,"btn_get_info onClick");
                    String userinfoJson = mAccountMrg.getCurrentUserInfo();
                    Toast.makeText(GetUserInfoActivity.this,userinfoJson,Toast.LENGTH_LONG).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }
}
