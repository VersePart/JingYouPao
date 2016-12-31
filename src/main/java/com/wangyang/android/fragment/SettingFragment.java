package com.wangyang.android.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wangyang.android.base.BaseFragment;


/**
 * Created by Administrator on 2016/12/27.
 */

public class SettingFragment extends BaseFragment {

    private static final String TAG = "SettingFragment";

    @Override
    public View initView() {
        Log.i(TAG, " 555");
        TextView view = new TextView(mContext);
        view.setText("555");
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
