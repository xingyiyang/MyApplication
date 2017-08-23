package com.scu.xing.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by xing on 2017/8/9.
 */

public class BCReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        Log.i("info","1收到广播消息："+s);
        Bundle bundle = new Bundle();
        bundle.putString("test","广播处理数据");
        setResultExtras(bundle);
    }
}
