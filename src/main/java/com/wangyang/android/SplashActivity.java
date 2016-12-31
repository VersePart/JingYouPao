package com.wangyang.android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wangyang.android.api.MyConstantConfig;
import com.wangyang.android.base.BaseActivity;
import com.wangyang.android.utils.SPutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */

public class SplashActivity extends BaseActivity {

    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Boolean ifFirst = SPutils.getBoolean(getApplicationContext(), MyConstantConfig.FIRST_OPEN);
        if(true){
            SPutils.putBoolean(getApplicationContext(), MyConstantConfig.FIRST_OPEN, true);
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
