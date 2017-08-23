package com.scu.xing.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by xing on 2017/8/8.
 */

public class ListViewActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contextcaidanview);
        showListView();
    }

    private void showListView(){
        ListView listView = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData());
        listView.setAdapter(adapter);
        this.registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderIcon(R.mipmap.a);
        menu.setHeaderTitle("标题");
        menu.add(1,1,1,"复制");
        menu.add(1,2,1,"粘贴");
        menu.add(2,3,1,"重命名");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(ListViewActivity.this,"复制",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(ListViewActivity.this,"粘贴",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(ListViewActivity.this,"重命名",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
        return super.onContextItemSelected(item);
    }

    private ArrayList<String> getData(){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<3;i++){
            list.add("list"+(i+1));
        }
        return list;
    }
}
