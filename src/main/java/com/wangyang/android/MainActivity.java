package com.wangyang.android;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wangyang.android.base.BaseFragment;
import com.wangyang.android.fragment.FriendFragment;
import com.wangyang.android.fragment.MainFragment;
import com.wangyang.android.fragment.RunFragment;
import com.wangyang.android.fragment.SettingFragment;
import com.wangyang.android.fragment.StateFragment;
import com.wangyang.android.widget.TopBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private FrameLayout mFrameLayout;
    private RadioGroup mRadioGroup;
    private List<BaseFragment> mBaseFragmentList = new ArrayList<BaseFragment>();
    private int mPosition;
    private Fragment mContext;
    private TopBar mTopBar;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initView() {
        mTopBar = (TopBar)findViewById(R.id.topbar);

        if(mBaseFragmentList != null){
            mBaseFragmentList.clear();
        }
        mBaseFragmentList.add(new MainFragment());
        mBaseFragmentList.add(new FriendFragment());
        mBaseFragmentList.add(new RunFragment());
        mBaseFragmentList.add(new StateFragment());
        mBaseFragmentList.add(new SettingFragment());
        mFrameLayout = (FrameLayout)findViewById(R.id.frame_layout);
        mRadioGroup = (RadioGroup)findViewById(R.id.radio_group);
        mRadioGroup.check(R.id.button_1);
        mRadioGroup.setOnCheckedChangeListener(new ChangeListener());

    }

    private void initFragment(){
        Log.i(TAG, "   mPosition = "+mPosition);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_layout, mBaseFragmentList.get(0)).commit();
        mContext = mBaseFragmentList.get(0);//初始化
        TopBarListener(mPosition);
    }

    private void TopBarListener(int position){
        switch (position){
            case 0:
                mTopBar.mLeftImageButton.setVisibility(View.INVISIBLE);
                mTopBar.mRightImageButton.setVisibility(View.INVISIBLE);
                mTopBar.mTitleText.setText("Verse Part");
                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
            case 4:
                mTopBar.mLeftImageButton.setVisibility(View.INVISIBLE);
                break;
            default:
                mTopBar.mLeftImageButton.setVisibility(View.VISIBLE);
                mTopBar.mRightImageButton.setVisibility(View.VISIBLE);
                mTopBar.mTitleText.setText("RUN");
                break;
        }
    }

    private class ChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.button_1:
                    mPosition = 0;
                    break;
                case R.id.button_2:
                    mPosition =1;
                    break;
                case R.id.button_3:
                    mPosition = 2;
                    break;
                case R.id.button_4:
                    mPosition = 3;
                    break;
                case R.id.button_5:
                    mPosition = 4;
                    break;
                default:
                    mPosition = 0;
                    break;
            }
            TopBarListener(mPosition);
            BaseFragment baseFragment = mBaseFragmentList.get(mPosition);
            switchFragment(mContext, baseFragment);
        }
    }

    private void switchFragment(Fragment from, Fragment to) {
        Log.i(TAG, "switchFragment   from = "+(from == null) +"   from != to "+(from != to ? "yes" : "no"));
        if(from != to){
            mContext = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //to添加了
            if(to.isAdded()){
                if (from != null){
                    ft.hide(from);
                }
                if (to != null){
                    ft.show(to).commit();
                }
            } else {
                if (from != null){
                    ft.hide(from);
                }
                if (to != null){
                    ft.add(R.id.frame_layout, to).commit();
                }
            }
        }
    }

}
