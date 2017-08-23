package com.scu.xing.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Created by xing on 2017/8/9.
 */

public class CreateFileActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fileview);

        initFile();
    }

    private void initFile(){
        Log.i("info","1");
        File file = new File(this.getFilesDir()+"/test.txt");
        Log.i("info","2");
        if(!file.exists()){
            try{
                file.createNewFile();
                Toast.makeText(CreateFileActivity.this,"文件创建成功",Toast.LENGTH_SHORT).show();
                Log.i("info","文件创建成功");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            Toast.makeText(CreateFileActivity.this,"文件已存在",Toast.LENGTH_SHORT).show();
            Log.i("info","文件已存在");
        }
        File file1 = this.getFilesDir();
        Log.i("info",file1.toString());
        File file2 = this.getExternalCacheDir();
        Log.i("info",file2.toString());
    }
}
