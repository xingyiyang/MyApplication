package com.scu.xing.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/8.
 */

public class CaidanActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caidanview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(1,100,1,"菜单一");
        menu.add(1,101,1,"菜单二");
        menu.add(1,102,1,"菜单三");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 100:
                Toast.makeText(CaidanActivity.this, "菜单一", Toast.LENGTH_SHORT).show();
                break;
            case 101:
                Toast.makeText(CaidanActivity.this, "菜单二", Toast.LENGTH_SHORT).show();
                break;
            case 102:
                Toast.makeText(CaidanActivity.this, "菜单三", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
