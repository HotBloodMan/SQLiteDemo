package com.ljt.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText mEtName;
    private EditText mEtPhone;
    private ContactInfoDao mDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDao=new ContactInfoDao(MainActivity.this);
        mEtName= (EditText) findViewById(R.id.mEtName);
        mEtPhone= (EditText) findViewById(R.id.mEtPhone);
    }

    public void add(View view){
        String name=mEtName.getText().toString().trim();
        String phone=mEtPhone.getText().toString().trim();
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)){
            Toast.makeText(this,"填写不完整",Toast.LENGTH_SHORT).show();
            return;
        }else{
            long addLong = mDao.addDate(name, phone);
            if(addLong==-1){
                Toast.makeText(this,"添加失败",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"数据添加在第  "+addLong+"   行",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void delete(View view){
        String name=mEtName.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"填写不完整",Toast.LENGTH_SHORT).show();
            return;
        }else{
            int deleteDate = mDao.deleteDate(name);
            if(deleteDate==-1){
                Toast.makeText(this,"删除失败",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"成功删除  "+deleteDate+"   条数据",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void update(View view){

        String name=mEtName.getText().toString().trim();
        String phone=mEtPhone.getText().toString().trim();
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)){
            Toast.makeText(this,"填写不完整",Toast.LENGTH_SHORT).show();
            return;
        }else{
            int count=mDao.updateData(name, phone);
            if(count==-1){
                Toast.makeText(this,"更新失败",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"数据更新了  "+count+"   行",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void query(View view){

        String name=mEtName.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"填写不完整",Toast.LENGTH_SHORT).show();
            return;
        }else{
            String phoneResult = mDao.alterData(name);

            Toast.makeText(this,"手机号码为:    "+phoneResult,Toast.LENGTH_SHORT).show();
        }
    }

}
