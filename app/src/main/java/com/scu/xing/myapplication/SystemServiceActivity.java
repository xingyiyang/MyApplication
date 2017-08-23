package com.scu.xing.myapplication;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/9.
 */

public class SystemServiceActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) SystemServiceActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.systemserviceview,null);
        setContentView(view);
    }

    public void doClickSys(View v){
        switch (v.getId()){
            case R.id.button60:
                nextworkConnected(SystemServiceActivity.this);
                break;
            case R.id.button61:
                controlWIFI(SystemServiceActivity.this);
                break;
            case R.id.button62:
                controlVolums(SystemServiceActivity.this);
                break;
            case R.id.button63:
                controlPackage(SystemServiceActivity.this);
                break;
            case R.id.button64:
                break;
            case R.id.button65:
                break;
            default:
                break;
        }
    }

    private void nextworkConnected(Context context){
        if(context != null){
            ConnectivityManager cm =  (ConnectivityManager)context.getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if(networkInfo!=null){
                if(networkInfo.isAvailable()){
                    Toast.makeText(SystemServiceActivity.this,"网络已经打开",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SystemServiceActivity.this,"网络未连接",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(SystemServiceActivity.this,"无法查看网络",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void controlWIFI(Context context){
        if(context != null){
            WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
            if(wifiManager.isWifiEnabled()){
                wifiManager.setWifiEnabled(false);
                Toast.makeText(SystemServiceActivity.this,"wifi已关闭",Toast.LENGTH_SHORT).show();

            }else{
                wifiManager.setWifiEnabled(true);
                Toast.makeText(SystemServiceActivity.this,"wifi已打开",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void controlVolums(Context context){
        if(context != null){
            AudioManager audioManager = (AudioManager) context.getSystemService(AUDIO_SERVICE);
            int maxvolums = audioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
            int currentvolums = audioManager.getStreamVolume(AudioManager.STREAM_RING);
            Toast.makeText(SystemServiceActivity.this,"max: "+maxvolums+" current: "+currentvolums,Toast.LENGTH_SHORT).show();

        }
    }

    private void controlPackage(Context context){
        if(context != null){
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
            String paname = activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
            Toast.makeText(SystemServiceActivity.this,"当前程序包名"+paname,Toast.LENGTH_LONG).show();

        }
    }
}
