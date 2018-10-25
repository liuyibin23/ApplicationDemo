package com.example.applicationdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.utils.AccountManager;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.utils.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

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
                final ProgressDialog pd = ProgressDialog.show(MainActivity.this, "Installing...", "Please wait...", true, true);
                // FIXME: 仅用于安装流程演示 2017/7/24
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simulateInstallExternalPlugin();
                        pd.dismiss();
                    }
                }, 1000);
//                PluginInfo info = RePlugin.getPluginInfo("plugindemo2");
//                if(info == null){
//                    Toast.makeText(MainActivity.this,"未找到plugindemo2",Toast.LENGTH_LONG).show();
//                } else {
//                    RePlugin.startActivity(MainActivity.this,RePlugin.createIntent("plugindemo2",
//                            "com.example.lyb.plugindemo2.MainActivity"));
//                }
            }
        });

    }

    /**
     * 模拟安装或升级（覆盖安装）外置插件
     * 注意：为方便演示，外置插件临时放置到Host的assets/external目录下
     */
    private void simulateInstallExternalPlugin() {
        String plugin2Apk = "plugindemo2.apk";
        String plugin2apkPath = "external" + File.separator + plugin2Apk;

        // 文件是否已经存在？直接删除重来
        String pluginFilePath = getFilesDir().getAbsolutePath() + File.separator + plugin2Apk;
        File pluginFile = new File(pluginFilePath);
        if (pluginFile.exists()) {
            FileUtils.deleteQuietly(pluginFile);
        }

        // 开始复制
        copyAssetsFileToAppFiles(plugin2apkPath, plugin2Apk);
        PluginInfo info = null;
        if (pluginFile.exists()) {
            info = RePlugin.install(pluginFilePath);
        }

        if (info != null) {
            RePlugin.startActivity(MainActivity.this, RePlugin.createIntent(info.getName(), "com.exam.lyb.plugindemo2.MainActivity"));
        } else {
            Toast.makeText(MainActivity.this, "install external plugin failed", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 从assets目录中复制某文件内容
     *  @param  assetFileName assets目录下的Apk源文件路径
     *  @param  newFileName 复制到/data/data/package_name/files/目录下文件名
     */
    private void copyAssetsFileToAppFiles(String assetFileName, String newFileName) {
        InputStream is = null;
        FileOutputStream fos = null;
        int buffsize = 1024;

        try {
            is = this.getAssets().open(assetFileName);
            fos = this.openFileOutput(newFileName, Context.MODE_PRIVATE);
            int byteCount = 0;
            byte[] buffer = new byte[buffsize];
            while((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
