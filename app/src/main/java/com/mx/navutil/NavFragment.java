package com.mx.navutil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class NavFragment extends Fragment {
    protected NavUtil navUtil;
    protected DialogUtil dialogUtil;

    @Override
    public void onResume() {
        super.onResume();
        dialogUtil = DialogUtil.getInstance(getActivity());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navUtil  = NavUtil.getInstance();
        navUtil.onCreate(getActivity());
        dialogUtil = DialogUtil.getInstance(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        navUtil.onDestory(getActivity());
    }
}
