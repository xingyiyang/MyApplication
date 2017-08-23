package com.scu.xing.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by xing on 2017/8/8.
 */

public class SqliteActivity extends Activity{

    private Button button35;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteview);
        SQLiteDatabase db = openOrCreateDatabase("user.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists usertb (_id integer primary key autoincrement, name text not null, age integer not null)");
        db.execSQL("insert into usertb(name,age) values('张三',20)");
        db.execSQL("insert into usertb(name,age) values('李四',18)");

        ContentValues contentValues = new ContentValues();
        contentValues.put("name","王五");
        contentValues.put("age",17);
        db.insert("usertb",null,contentValues);

        contentValues.clear();
        contentValues.put("name","赵六");
        contentValues.put("age",16);
        db.insert("usertb",null,contentValues);

        contentValues.clear();
        contentValues.put("name","李七");
        contentValues.put("age",14);
        db.insert("usertb",null,contentValues);

        contentValues.clear();
        contentValues.put("age",15);
        db.update("usertb",contentValues,"age>?",new String[]{"19"});//将age大于19的改成15

        db.delete("usertb","name like ?",new String[]{"%李%"});

        Cursor c = db.query("usertb",null,"_id>?",new String[]{"0"},null,null,"age");
        if(c!=null){
            String[] colums = c.getColumnNames();
            while (c.moveToNext()){
                for(String columname:colums){
                    Log.i("info",c.getString(c.getColumnIndex(columname)));
                }
            }
            c.close();
        }

        Cursor cursor = db.rawQuery("select * from usertb",null);
        if(cursor!=null){
            int i=1;
            while (cursor.moveToNext()){
                Log.i("info","id: "+cursor.getInt(cursor.getColumnIndex("_id")));
                Log.i("info","name: "+cursor.getString(cursor.getColumnIndex("name")));
                Log.i("info","age: "+cursor.getInt(cursor.getColumnIndex("age")));
                Log.i("info","count: "+i++);
            }
            cursor.close();
        }
        db.close();

        button35 = (Button)findViewById(R.id.button35);
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SqliteActivity.this,SqliteHelperActivity.class);
                startActivity(intent);
            }
        });
    }
}
