package com.mx.navutil;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class NavActivity extends Activity {
    protected NavUtil navUtil;
    protected DialogUtil dialogUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navUtil  = NavUtil.getInstance();
        navUtil.onCreate(this);
        dialogUtil = DialogUtil.getInstance(this);
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
