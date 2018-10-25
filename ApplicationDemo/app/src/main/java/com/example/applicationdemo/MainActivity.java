package com.example.applicationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.utils.AccountManager;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
//        ViewGroup containerView = (ViewGroup) findViewById(R.id.container);
//
//        TreeNode root = TreeNode.root();
//        TreeNode parent = new TreeNode("ParentNode");
//        TreeNode child0 = new TreeNode("ChildNode0");
//        TreeNode child1 = new TreeNode("ChildNode1");
//        parent.addChildren(child0,child1);
//        root.addChild(parent);
//        AndroidTreeView tView = new AndroidTreeView(this,root);
////        mainLayout = (LinearLayout)findViewById(R.id.activity_main);
////        mainLayout.addView(tView.getView());
//        containerView.addView(tView.getView());
    }


    private void initView(){
        Button btnP1 = (Button) findViewById(R.id.btn_plugin1);
        btnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PluginInfo info = RePlugin.getPluginInfo("plugindemo1");
                if(info == null){
                    Toast.makeText(MainActivity.this,"未找到plugindemo1",Toast.LENGTH_LONG).show();
                } else {
                    RePlugin.startActivity(MainActivity.this,RePlugin.createIntent("plugindemo1",
                            "com.example.lyb.plugindemo1.MainActivity"));
                }

            }
        });

        Button btnSetAccount = (Button)findViewById(R.id.btn_set_account);
        btnSetAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountManager.getInstance().getCurrentUserInfo().setLogin(true);
                AccountManager.getInstance().getCurrentUserInfo().setUsername("testuser");
                Toast.makeText(MainActivity.this,"设置成功",Toast.LENGTH_LONG).show();
            }
        });

        Button btnP2 = (Button)findViewById(R.id.btn_plugin2);
        btnP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PluginInfo info = RePlugin.getPluginInfo("plugindemo2");
                if(info == null){
                    Toast.makeText(MainActivity.this,"未找到plugindemo2",Toast.LENGTH_LONG).show();
                } else {
                    RePlugin.startActivity(MainActivity.this,RePlugin.createIntent("plugindemo2",
                            "com.example.lyb.plugindemo2.MainActivity"));
                }
            }
        });

    }

}
