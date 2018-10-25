package com.example.lyb.plugindemo1

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lyb.plugindemo1.utils.UserInfo
import com.example.utils.IAccountMrg
import com.google.gson.Gson
import com.qihoo360.replugin.RePlugin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView(){
        btn_host.setOnClickListener {
            val hostContext = RePlugin.getHostContext()
            if (hostContext == null){
                Toast.makeText(this,"未找到host",Toast.LENGTH_LONG).show()
            } else{
//                RePlugin.startActivity(this@MainActivity,RePlugin.createIntent())
                val intent = Intent()
                intent.component = ComponentName("com.example.applicationdemo","com.example.applicationdemo.SecondActivity")
                startActivity(intent)
            }
        }

        btn_userinfo.setOnClickListener {
            val binder = RePlugin.getGlobalBinder("host")
            if(binder == null){
                Toast.makeText(this,"未找到host中的方法",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val accountMrg = IAccountMrg.Stub.asInterface(binder)
            val userInfoJson = accountMrg.currentUserInfo
            Toast.makeText(this,accountMrg.currentUserInfo,Toast.LENGTH_LONG).show()
            val g = Gson()
            val userInfo = g.fromJson(userInfoJson,UserInfo::class.java)
            userInfo
        }
    }
}
