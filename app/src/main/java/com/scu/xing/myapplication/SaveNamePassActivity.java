package com.scu.xing.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/8.
 */

public class SaveNamePassActivity extends Activity{

    private EditText editText2;
    private EditText editText4;
    private CheckBox checkBox;
    private Button button33;
    private Button button34;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginview);

        editText2 = (EditText)findViewById(R.id.editText2);
        editText4 = (EditText)findViewById(R.id.editText4);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        button33 = (Button)findViewById(R.id.button33);
        button34 = (Button)findViewById(R.id.button34);
        pref = getSharedPreferences("userInfo",MODE_PRIVATE);
        editor = pref.edit();
        String name = pref.getString("username","");
        if(name == null){
            checkBox.setChecked(false);
        }else{
            checkBox.setChecked(true);
            editText2.setText(name);
        }


    }

    public void doClick(View v){
        switch (v.getId()){
            case R.id.button33:
                String name = editText2.getText().toString().trim();
                String password= editText4.getText().toString().trim();
                if("admin".equals(name) && "123".equals(password)){
                    if(checkBox.isChecked()){
                        editor.putString("username",name);
                        editor.putString("password",password);
                        editor.commit();

                    }else {
                        editor.remove("username");
                        editor.commit();
                    }
                    Toast.makeText(SaveNamePassActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SaveNamePassActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(SaveNamePassActivity.this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button34:
                break;
            default:
                break;
        }
    }
}
