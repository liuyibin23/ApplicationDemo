package com.example.lyb.plugindemo1

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
    }
}
