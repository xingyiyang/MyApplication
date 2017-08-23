package com.scu.xing.myapplication;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by xing on 2017/8/9.
 */

public class ServiceActivity extends Activity{

    Intent intent1;
    Intent intent2;
    MyBindService myBindService;
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBindService = ((MyBindService.myBind)iBinder).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serviceview);
    }

    public void doClickSV(View v){

        switch (v.getId()){
            case R.id.button50:
                intent1 = new Intent(ServiceActivity.this,MyStartService.class);
                startService(intent1);
                break;
            case R.id.button52:
                stopService(intent1);
                break;
            case R.id.button53:
                intent2 = new Intent(ServiceActivity.this,MyBindService.class);
                bindService(intent2,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.button58:
                unbindService(conn);
                break;
            case R.id.button54:
                myBindService.play();
                break;
            case R.id.button55:
                myBindService.pre();
                break;
            case R.id.button56:
                myBindService.next();
                break;
            case R.id.button57:
                myBindService.zanting();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {

        stopService(intent2);
        unbindService(conn);
        super.onDestroy();
    }
}
