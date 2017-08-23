package com.scu.xing.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xing on 2017/8/9.
 */

public class WriteReadFileActivity extends Activity{

    private EditText editText6;
    private Button button40;
    private TextView textView5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writereadfileview);

        editText6 = (EditText)findViewById(R.id.editText6);
        button40 = (Button) findViewById(R.id.button40);
        textView5 = (TextView) findViewById(R.id.textView5);

        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeFile(editText6.getText().toString());
                textView5.setText(readFile());
            }
        });
    }

    private void writeFile(String content){
        try {
            FileOutputStream fos = openFileOutput("a.txt",MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private String readFile(){
        String content = null;
        try{
            FileInputStream fis = openFileInput("a.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer= new byte[1024];
            int len=0;
            while ((len=fis.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            content = baos.toString();
            fis.close();
            baos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return content;
    }
}
