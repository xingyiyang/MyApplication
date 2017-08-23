package com.scu.xing.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by xing on 2017/8/9.
 */

public class BCReceiver3 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("info","收到异步广播消息");
    }
}
