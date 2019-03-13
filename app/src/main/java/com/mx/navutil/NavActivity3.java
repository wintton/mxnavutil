package com.mx.navutil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class NavActivity3 extends NavAppCompatActivity{

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navtest);
        textView = (TextView)this.findViewById(R.id.text);
        textView.setText("点我：reLacunch");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navUtil.reLaunch(NavActivity1.class);
            }
        });
    }
}