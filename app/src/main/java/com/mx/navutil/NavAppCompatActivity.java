package com.mx.navutil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 2019-03-13
 * 灵，周文强  自己定义的一个Activity，提供两个工具，一个路由工具，一个提示窗工具
 * 梦辛工作室
 */
public class NavAppCompatActivity extends AppCompatActivity {

    protected NavUtil navUtil;
    protected DialogUtil dialogUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navUtil  = NavUtil.getInstance();
        navUtil.onCreate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dialogUtil = DialogUtil.getInstance(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        navUtil.onDestory(this);
    }
}
