package com.example.applicationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
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
}
