package com.scu.xing.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xing on 2017/8/8.
 */

public class DbOpenHelper extends SQLiteOpenHelper{

    public DbOpenHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    //首次创建数据库的时候调用，用于建库建表
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists stutb(_id integer primary key autoincrement, name text not null, age integer not null)");
        db.execSQL("insert into stutb(name,age) values('fty',22)");
    }

    @Override
    //数据库的版本发生变化时自动调用
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
