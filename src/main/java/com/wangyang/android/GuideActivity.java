package com.wangyang.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wangyang.android.adapter.GuideAdapter;
import com.wangyang.android.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public class GuideActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "GuideActivity";
    private  ViewPager mViewPager;
    private LinearLayout mLinearLayout;
    private List<View> mViewList = new ArrayList<View>();
    private int[] mPagers = {R.layout.guide_view_1, R.layout.guide_view_2, R.layout.guide_view_3};
    private int mPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);
        init();
        initData();

    }

    private void initData() {
        GuideAdapter adapter = new GuideAdapter(mViewList);
        mViewPager.setAdapter(adapter);
    }

    private void init() {
        if(mViewList != null){
            mViewList.clear();
        }
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < mPagers.length; i++){
            View view = inflater.inflate(mPagers[i], null);
            mViewList.add(view);
            if(i == (mPagers.length - 1)){
                Button button = (Button)view.findViewById(R.id.guide_button);
                button.setOnClickListener(this);
            }
        }
        mViewPager = (ViewPager)findViewById(R.id.view_pager);
        mLinearLayout = (LinearLayout)findViewById(R.id.ll);
        mViewPager.addOnPageChangeListener(new GuideViewPagerChange());
        ((ImageView)mLinearLayout.getChildAt(0)).setImageResource(R.drawable.point2);
        mPosition = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guide_button:
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                finish();
        }
    }

    private class GuideViewPagerChange implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            Log.i(TAG, " onPageScrolled  position = "+position+"  positionOffset = "+positionOffset+"    positionOffsetPixels = "+positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            ((ImageView)mLinearLayout.getChildAt(position)).setImageResource(R.drawable.point2);
            ((ImageView)mLinearLayout.getChildAt(mPosition)).setImageResource(R.drawable.point1);
            mPosition = position;
            Log.i(TAG, "onPageSelected   position = "+position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
//            Log.i(TAG, " onPageScrollStateChanged  state = "+state);
        }
    }
}
