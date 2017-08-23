package com.scu.xing.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by xing on 2017/8/8.
 */

public class ShareprefActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blankview);
        //SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(NextActivity.this);
        SharedPreferences pref = getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name","张三");
        editor.putInt("age",20);
        editor.putLong("time",System.currentTimeMillis());
        editor.putBoolean("default",true);
        editor.commit();
        System.out.println(pref.getString("name",""));
        System.out.println(pref.getInt("age",0));
    }
}
