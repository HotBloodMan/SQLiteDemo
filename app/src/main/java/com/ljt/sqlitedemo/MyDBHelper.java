package com.ljt.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ${JT.L} on 2017/9/26.
 *
 * 很长时间写原生数据库，练练手
 *
 */

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context){
        super(context,"hello.db",null,2);
    }

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table contactinfo (id integer primary key autoincrement, name verchar(20), phone varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table contactinfo add account varchar(20)");
    }
}
