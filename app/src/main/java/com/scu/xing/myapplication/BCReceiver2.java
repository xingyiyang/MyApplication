package com.scu.xing.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by xing on 2017/8/9.
 */

public class BCReceiver2 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        Log.i("info","2收到广播消息："+s);
        //abortBroadcast();//截断广播
        Bundle bundle = getResultExtras(true);
        String s2 = bundle.getString("test");
        Log.i("info","2收到处理后广播消息："+s2);
    }
}
