package com.scu.xing.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by xing on 2017/8/8.
 */

public class SqliteHelperActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlitehelpview);

        DbOpenHelper dbOpenHelper = new DbOpenHelper(SqliteHelperActivity.this,"stu.db");
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from stutb",null);
        if(cursor!=null){
            String[] cu = cursor.getColumnNames();
            while (cursor.moveToNext()){
                for(String columname:cu){
                    Log.i("info",columname+" : "+cursor.getString(cursor.getColumnIndex(columname)));
                }
            }
            cursor.close();
        }
        db.close();

    }
}
