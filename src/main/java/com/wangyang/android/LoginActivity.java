package com.wangyang.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wangyang.android.api.MyConstantConfig;
import com.wangyang.android.base.BaseActivity;
import com.wangyang.android.utils.SPutils;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

/**
 * Created by Verse Part on 2017/1/3.
 * email: versepartwang@163.com
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    private EditText mUserName;
    private EditText mPassword;
    private Button mUsernameClear;
    private Button mPasswordEye;
    private Button mPasswordClear;
    private Button mLogIn;
    private Button mRegisterUser;
    private Button mForgetPwd;
    private TextView mTextThirdParty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        mTextThirdParty = (TextView)findViewById(R.id.text_third_party);

        mUsernameClear.setOnClickListener(this);
        mPasswordEye.setOnClickListener(this);
        mPasswordClear.setOnClickListener(this);
        mLogIn.setOnClickListener(this);
        mRegisterUser.setOnClickListener(this);
        mForgetPwd.setOnClickListener(this);

        mTextThirdParty.setOnClickListener(this);

        mUserName.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!mUserName.getText().toString().equals("")){
                    mUsernameClear.setVisibility(View.VISIBLE);
                } else {
                    mUsernameClear.setVisibility(View.INVISIBLE);
                }
            }
        });
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                Log.i(TAG, "afterTextChanged    mPassword.getText() = "+(mPassword.getText().toString().equals("")) +"  getText = "+mPassword.getText());
                if(!mPassword.getText().toString().equals("")){
                    mPasswordClear.setVisibility(View.VISIBLE);
                } else {
                    mPasswordClear.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_username_clear:
                    mUserName.setText("");
                break;
            case R.id.bt_pwd_eye:
                boolean isEye = SPutils.getBoolean(getApplicationContext(), MyConstantConfig.BT_PWD_EYE, false);
                if (isEye){
                    SPutils.putBoolean(getApplicationContext(), MyConstantConfig.BT_PWD_EYE, false);
                    mPasswordEye.setBackgroundResource(R.drawable.log_in_privacy_on);
                    mPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mPassword.setSelection(mPassword.length());
                } else {
                    SPutils.putBoolean(getApplicationContext(), MyConstantConfig.BT_PWD_EYE, true);
                    mPasswordEye.setBackgroundResource(R.drawable.log_in_icon_privacy_off);
                    mPassword.setInputType(129);
//                    mPassword.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
                    mPassword.setSelection(mPassword.length());
                }
                break;
            case R.id.bt_pwd_clear:
                mPassword.setText("");
                break;
            case R.id.log_in_button:
                String user = mUserName.getText().toString();
                String password = mPassword.getText().toString();
                if (user.equals("") | password.equals("")){
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.import_is_mistake), Toast.LENGTH_LONG);
                    break;
                }
                //登陆账号
                break;
            case R.id.register_btn:
                break;
            case R.id.forget_btn:
                break;
            case R.id.text_third_party:
                break;
            default:
                break;

        }
    }
}
