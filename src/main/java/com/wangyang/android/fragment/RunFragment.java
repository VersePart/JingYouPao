package com.wangyang.android.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wangyang.android.base.BaseFragment;


/**
 * Created by Administrator on 2016/12/27.
 */

public class RunFragment extends BaseFragment {

    private static final String TAG = "RunFragment";

    @Override
    public View initView() {
        Log.i(TAG, " 333");
        TextView view = new TextView(mContext);
        view.setText("333");
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
