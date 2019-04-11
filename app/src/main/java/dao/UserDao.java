package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Sqlite.SqliteHelper;
import bean.UserBean;

public class UserDao {
    private SQLiteDatabase database;
    public  UserDao(Context context){
        SqliteHelper helper=new SqliteHelper(context);
        database=helper.getReadableDatabase();
    }
    //添加
    public void  add(String name,String pass){

        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("pass",pass);
        database.insert("user",null,values);

    }

    //查询
    public List<UserBean> select(){
        Cursor cursor=database.query("user",null,null,null,null,null,null);
        List <UserBean> list=new ArrayList<>();
        while (cursor.moveToNext()){
            String namee=cursor.getString(cursor.getColumnIndex("name"));
            String passes=cursor.getString(cursor.getColumnIndex("pass"));
            UserBean userBean=new UserBean(namee,passes);
            list.add(userBean);
        }
     return list;
    }
    //shanchu删除

    public  void  delete(String name){
        database.delete("user","name=?",new String[]{name});
    }

}
