package com.bawei.myshujuku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dao.UserDao;

public class MainActivity extends AppCompatActivity {

    private EditText ed_edit1,ed_edit2;

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //资源id
        ed_edit1=findViewById(R.id.ed_edit);
        ed_edit2=findViewById(R.id.ed_edit2);

        //
        userDao=new UserDao(this);


    }

    public void deng(View view) {
        Intent intent=new Intent(this,SelectActivity.class);
        startActivity(intent);
    }

    //注册 点击跳转
    public void zhu(View view) {

        Intent intent=new Intent(this,AddActivity.class);
        startActivity(intent);
    }
}
