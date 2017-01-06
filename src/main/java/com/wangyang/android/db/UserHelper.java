package com.wangyang.android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wangyang.android.R;

import static android.R.attr.version;

/**
 * Created by Verse Part on 2017/1/5.
 * email: versepartwang@163.com
 */

public class UserHelper extends SQLiteOpenHelper {

    private static final String DATABASE_USERS = "user.db";
    public static final String TABLE_REGISTER = "register_info";

    public static final String USE_NAME = "use_name";
    public static final String PASSWORD = "password";
    public static final String NICKNAME = "nickname";
    public static final String AGE = "age";
    public static final String SEX = "sex";
    public static final String HEIGHT = "height";
    public static final String WEIGHT = "weight";
    public static final String PICTURE = "picture";
    public static final String ADDRESS = "address";


    public UserHelper(Context context) {
        super(context, DATABASE_USERS, null, R.string.version_users);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE register_info(_id INTEGER PRIMARY KEY AUTOINCREMENT,use_name TEXT, password TEXT, nickname TEXT, age TEXT, sex TEXT, height TEXT, weight TEXT, picture TEXT, address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String user, String password){
        ContentValues values = new ContentValues();
        values.put(USE_NAME, user);
        values.put(PASSWORD, password);
        long insert = getWritableDatabase().insert(TABLE_REGISTER, null, values);
        if (insert == -1){
            return false;
        } else {
            return true;
        }
    }

    public boolean delete(){

        return true;
    }

    public boolean update(){

        return true;
    }

    public Cursor query(String table, String[] columns, String selection,String[] selectionArgs, String groupBy, String having,String orderBy){
        Cursor cursor = getReadableDatabase().query(table, columns,selection ,selectionArgs, groupBy, having, orderBy);
        return cursor;
    }
}
