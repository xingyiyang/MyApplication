package com.scu.xing.myapplication;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by xing on 2017/8/9.
 */

public class MyBindService extends Service{

    @Override
    public void onCreate() {
        Log.i("info","MyBindService---onCreate");
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info","MyBindService---onBind");
        return new myBind();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.i("info","MyBindService---unbindService");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.i("info","MyBindService---onDestroy");
        super.onDestroy();
    }

    public class myBind extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }
    }

    public void play(){
        Log.i("info","播放");
    }

    public void zanting(){
        Log.i("info","暂停");
    }

    public void pre(){
        Log.i("info","上一首");
    }

    public void next(){
        Log.i("info","下一首");
    }
}
