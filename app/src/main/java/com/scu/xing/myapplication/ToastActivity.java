package com.scu.xing.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/7.
 */

public class ToastActivity extends Activity{

    private Button button4;
    private Button button9;
    private Button button10;
    private Button button11;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toastview);

        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
            }
        });

        button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast2();
            }
        });

        button10 = (Button)findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast3();
            }
        });

        button11 = (Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast4();
            }
        });

    }

    private void showToast(){
        Toast toast = Toast.makeText(this,R.string.app_name,Toast.LENGTH_SHORT);
        toast.show();
    }

    private void showToast2(){
        Toast toast = Toast.makeText(this,"改变位置的toast",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    private void showToast3(){
        Toast toast = Toast.makeText(this,"带有图片的toast",Toast.LENGTH_SHORT);
        LinearLayout linearLayout = (LinearLayout) toast.getView();
        ImageView im = new ImageView(this);
        im.setImageResource(R.mipmap.ic_launcher);
        linearLayout.addView(im,0);
        toast.show();
    }

    private void showToast4(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View toastview = inflater.inflate(R.layout.toastlayout,null);
        Toast toast = new Toast(this);
        toast.setView(toastview);
        toast.show();
    }

}
