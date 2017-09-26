package com.ljt.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ${JT.L} on 2017/9/26.
 */

public class ContactInfoDao {

    private MyDBHelper myDBHelper;

    public ContactInfoDao(Context context) {
        this.myDBHelper = new MyDBHelper(context);
    }
    //添加
    public long addDate(String name,String phone){
        SQLiteDatabase writableDatabase = myDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        long rowid = writableDatabase.insert("contactinfo", null, contentValues);
        writableDatabase.close();
        return rowid;
    }
    //删除
    public int deleteDate(String name){
        SQLiteDatabase sqLiteDatabase = myDBHelper.getWritableDatabase();
        int deleteResult = sqLiteDatabase.delete("contactinfo", "name=?", new String[]{name});
        sqLiteDatabase.close();
        return deleteResult;
    }
    //修改
    public int updateData(String name,String newPhone){
        SQLiteDatabase sqLiteDatabase = myDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone",newPhone);
        int update = sqLiteDatabase.update("contactinfo", contentValues, "name=?", new String[]{name});
        sqLiteDatabase.close();
        return update;
    }
    //查询
    public String alterData(String name){
        String phone=null;
        SQLiteDatabase readableDatabase = myDBHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query("contactinfo", new String[]{"phone"}, "name=?", new String[]{name}, null, null, null);
        if(cursor.moveToNext()){
            phone=cursor.getString(0);
        }
        cursor.close();
        readableDatabase.close();
        return phone;
    }

}
