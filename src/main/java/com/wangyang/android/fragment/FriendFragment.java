package com.wangyang.android.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wangyang.android.base.BaseFragment;


/**
 * Created by Administrator on 2016/12/27.
 */

public class FriendFragment extends BaseFragment {

    private static final String TAG = "FriendFragment";


    @Override
    public View initView() {
        Log.i(TAG, " 222");
        TextView view = new TextView(mContext);
        view.setText("222");
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
