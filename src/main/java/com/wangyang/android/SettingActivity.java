package com.wangyang.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wangyang.android.api.MyConstantConfig;
import com.wangyang.android.base.BaseActivity;
import com.wangyang.android.utils.SPutils;

import static com.wangyang.android.utils.SPutils.getBoolean;

/**
 * Created by Verse Part on 2017/1/3.
 * email: versepartwang@163.com
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "SettingActivity";

    private EditText mUserName;
    private EditText mPassword;
    private Button mUsernameClear;
    private Button mPasswordEye;
    private Button mPasswordClear;
    private Button mLogIn;
    private Button mRegisterUser;
    private Button mForgetPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }

    private void init() {
        mUserName = (EditText)findViewById(R.id.username);
        mPassword = (EditText)findViewById(R.id.password);
        mUsernameClear = (Button)findViewById(R.id.bt_username_clear);
        mPasswordEye = (Button)findViewById(R.id.bt_pwd_eye);
        mPasswordClear = (Button)findViewById(R.id.bt_pwd_clear);
        mLogIn = (Button)findViewById(R.id.log_in_button);
        mRegisterUser = (Button)findViewById(R.id.register_btn);
        mForgetPwd = (Button)findViewById(R.id.forget_btn);

        mUsernameClear.setOnClickListener(this);
        mPasswordEye.setOnClickListener(this);
        mPasswordClear.setOnClickListener(this);
        mLogIn.setOnClickListener(this);
        mRegisterUser.setOnClickListener(this);
        mForgetPwd.setOnClickListener(this);

        mUserName.addTextChangedListener(new textWatcher());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_username_clear:
                if (mUserName.getText() != null){
                    mUserName.setText("");
                }
                break;
            case R.id.bt_pwd_eye:
                boolean isEye = SPutils.getBoolean(getApplicationContext(), MyConstantConfig.BT_PWD_EYE, false);
                if (isEye){
                    SPutils.putBoolean(getApplicationContext(), MyConstantConfig.BT_PWD_EYE, false);
                    mPasswordEye.setBackgroundResource(R.drawable.log_in_icon_privacy_off);
                } else {
                    SPutils.putBoolean(getApplicationContext(), MyConstantConfig.BT_PWD_EYE, true);
                    mPasswordEye.setBackgroundResource(R.drawable.log_in_privacy_on);
                }
                break;
            case R.id.bt_pwd_clear:
                if (mPasswordClear.getText() != null){
                    mPasswordClear.setText("");
                }
                break;
            case R.id.log_in_button:
                break;
            case R.id.register_btn:
                break;
            case R.id.forget_btn:
                break;
            default:
                break;

        }
    }

    private class textWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
