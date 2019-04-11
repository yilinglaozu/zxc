package com.bawei.myshujuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

import adapter.MyBase;
import bean.UserBean;
import dao.UserDao;

public class SelectActivity extends AppCompatActivity {

    private GridView listView;
    private UserDao userDao;
    private  List<UserBean> select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        listView=findViewById(R.id.listview);

        userDao=new UserDao(this);
        //
       select = userDao.select();
       //适配器
        final MyBase adapter=new MyBase(select,this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                userDao.delete(select.get(position).getName());
                select.remove(position);
                adapter.notifyDataSetChanged();
                //集合

            }
        });



    }
}
