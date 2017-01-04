package com.wangyang.android.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wangyang.android.LoginActivity;
import com.wangyang.android.MainActivity;
import com.wangyang.android.R;
import com.wangyang.android.base.BaseFragment;


/**
 * Created by Administrator on 2016/12/27.
 */

public class SettingFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "SettingFragment";
    private RelativeLayout mLogin;
    private RelativeLayout mEdit;
    private RelativeLayout mSetting;
    private RelativeLayout mAbout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting,container, false);
        mLogin = (RelativeLayout)view.findViewById(R.id.settings_login);
        mEdit = (RelativeLayout)view.findViewById(R.id.settings_edit);
        mSetting = (RelativeLayout)view.findViewById(R.id.settings_setting);
        mAbout = (RelativeLayout)view.findViewById(R.id.settings_about);

        mLogin.setOnClickListener(this);
        mEdit.setOnClickListener(this);
        mSetting.setOnClickListener(this);
        mAbout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.settings_login:
                beginActivity(LoginActivity.class);
                Toast.makeText(mContext, "dddd" , Toast.LENGTH_LONG).show();
                break;
            case R.id.settings_edit:
                Toast.makeText(mContext, "dddd" , Toast.LENGTH_LONG).show();
                break;
            case R.id.settings_setting:
                Toast.makeText(mContext, "dddd" , Toast.LENGTH_LONG).show();
                break;
            case R.id.settings_about:
                Toast.makeText(mContext, "dddd" , Toast.LENGTH_LONG).show();
                break;

        }
    }

    private void beginActivity(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }
}
