package com.scu.xing.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by xing on 2017/8/8.
 */

public class NextActivity extends Activity{

    private Button button31;
    private Button button32;
    private Button button36;
    private Button button38;
    private Button button41;
    private Button button42;
    private Button button44;
    private Button button47;
    private Button button51;
    private Button button59;
    private Button button66;
    private Button button67;
    private Button button68;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextview);

        button31 = (Button)findViewById(R.id.button31);
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, ShareprefActivity.class);
                startActivity(intent);
            }
        });

        button32 = (Button)findViewById(R.id.button32);
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, SaveNamePassActivity.class);
                startActivity(intent);
            }
        });

        button36 = (Button)findViewById(R.id.button36);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, SqliteActivity.class);
                startActivity(intent);
            }
        });

        button38 = (Button)findViewById(R.id.button38);
        button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, CreateFileActivity.class);
                startActivity(intent);
            }
        });

        button41 = (Button)findViewById(R.id.button41);
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, WriteReadFileActivity.class);
                startActivity(intent);
            }
        });

        button42 = (Button)findViewById(R.id.button42);
        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, CtpActivity.class);
                startActivity(intent);
            }
        });

        button44 = (Button)findViewById(R.id.button44);
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, CtpwActivity.class);
                startActivity(intent);
            }
        });

        button47 = (Button)findViewById(R.id.button47);
        button47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, GuangboActivity.class);
                startActivity(intent);
            }
        });

        button51 = (Button)findViewById(R.id.button51);
        button51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        button59 = (Button)findViewById(R.id.button59);
        button59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, SystemServiceActivity.class);
                startActivity(intent);
            }
        });

        button66 = (Button)findViewById(R.id.button66);
        button66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, GestureActivity1.class);
                startActivity(intent);
            }
        });

        button67 = (Button)findViewById(R.id.button67);
        button67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, GestureActivity2.class);
                startActivity(intent);
            }
        });

        button68 = (Button)findViewById(R.id.button68);
        button68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, GestureActivity3.class);
                startActivity(intent);
            }
        });

    }
}
