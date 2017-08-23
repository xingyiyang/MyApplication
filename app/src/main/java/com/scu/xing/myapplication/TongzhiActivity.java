package com.scu.xing.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by xing on 2017/8/7.
 */

public class TongzhiActivity extends Activity{

    NotificationManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tongzhiview);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        initEvent();
    }

    private void initEvent(){
        findViewById(R.id.button26).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentNotification();
            }
        });
        findViewById(R.id.button27).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quxiaoNotification();
            }
        });
    }

    private void sentNotification(){
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pintent = PendingIntent.getActivity(this,0,intent,0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.a);
        builder.setTicker("hello");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("标题");
        builder.setContentText("我是内容");
        builder.setContentIntent(pintent);
        builder.setAutoCancel(true);
//        builder.setDefaults(Notification.DEFAULT_SOUND);
//        builder.setDefaults(Notification.DEFAULT_LIGHTS);
//        builder.setDefaults(Notification.DEFAULT_VIBRATE);
        builder.setDefaults(Notification.DEFAULT_ALL);
        Notification notification = builder.getNotification();
        manager.notify(1,notification);

    }

    private void quxiaoNotification(){
        manager.cancel(1);
    }
}
