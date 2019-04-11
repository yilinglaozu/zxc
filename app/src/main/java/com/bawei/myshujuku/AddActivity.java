package com.bawei.myshujuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dao.UserDao;

public class AddActivity extends AppCompatActivity {

    private EditText ed_edit1,ed_edit21;
    private Button button;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ed_edit1=findViewById(R.id.ed_edit1);
        ed_edit21=findViewById(R.id.ed_edit21);
        userDao=new UserDao(this);

    }

    //注册  添加
    public void add(View view) {

        String name=ed_edit1.getText().toString();
        String pass=ed_edit21.getText().toString();
        userDao.add(name,pass);
        finish();

    }
}
