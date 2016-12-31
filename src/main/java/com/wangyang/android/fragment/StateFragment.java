package com.wangyang.android.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wangyang.android.base.BaseFragment;


/**
 * Created by Administrator on 2016/12/27.
 */

public class StateFragment extends BaseFragment {

    private static final String TAG = "StateFragment";

    @Override
    public View initView() {
        Log.i(TAG, " 444");
        TextView view = new TextView(mContext);
        view.setText("444");
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
