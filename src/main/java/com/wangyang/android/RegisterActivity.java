package com.wangyang.android;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wangyang.android.base.BaseActivity;
import com.wangyang.android.db.UserHelper;
import com.wangyang.android.widget.TopBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Verse Part on 2017/1/5.
 * email: versepartwang@163.com
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private static final String TAG = "RegisterActivity";
    private EditText mUserName;
    private EditText mPassword;
    private Button mUsernameClear;
    private Button mPasswordClear;
    private Button mSureBtn;
    private List<String> mList = new ArrayList<String>();
    private UserHelper mUserHelper;
    private TopBar mTopBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        editTextListener();
    }

    private void init() {

        mTopBar = (TopBar)findViewById(R.id.topbar);
        mTopBar.mLeftImageButton.setOnClickListener(this);

        mUserName = (EditText)findViewById(R.id.reg_user);
        mPassword = (EditText)findViewById(R.id.reg_pwd);
        mUsernameClear = (Button)findViewById(R.id.bt_username_clear);
        mPasswordClear = (Button)findViewById(R.id.bt_password_clear);
        mSureBtn = (Button)findViewById(R.id.sure_btn);

        mUsernameClear.setOnClickListener(this);
        mPasswordClear.setOnClickListener(this);
        mSureBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_username_clear:
                mUserName.setText("");
                break;
            case R.id.bt_password_clear:
                mPassword.setText("");
                break;
            case R.id.sure_btn:
                String userName = mUserName.getText().toString();
                String password = mPassword.getText().toString();
                if (userName.equals("") | password.equals("")){
                    Toast.makeText(getApplicationContext(), R.string.import_is_mistake, Toast.LENGTH_LONG).show();
                    return;
                }
                if (mList.contains(userName)){
                    Toast.makeText(getApplicationContext(), R.string.user_is_exist, Toast.LENGTH_LONG).show();
                    return;
                }
                boolean insert = mUserHelper.insert(userName, password);
                if (insert){
                    Log.i(TAG, "插入成功");
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.insert_db_failed, Toast.LENGTH_LONG).show();
                }
                break;
            case TopBar.LEFTID:
                finish();
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mList.clear();
        loadUserDB();
    }

    private void loadUserDB() {
        mUserHelper = new UserHelper(getApplicationContext());
        Log.i(TAG, " loadUserDB     ");
        new Thread(){
            @Override
            public void run() {
                Cursor cursor = mUserHelper.query(UserHelper.TABLE_REGISTER, new String[]{"use_name"}, null, null, null, null, null);
                if (cursor != null){
                    while (cursor.moveToNext()){
                        int useNameIndex = cursor.getColumnIndexOrThrow("use_name");
                        String useName = cursor.getString(useNameIndex);
                        mList.add(useName);
                    }
                }
                Log.i(TAG, " loadUserDB    mList = "+mList.toString());
                if (cursor != null){
                    cursor.close();
                }
            }
        }.start();
    }

    private void editTextListener(){
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
}
