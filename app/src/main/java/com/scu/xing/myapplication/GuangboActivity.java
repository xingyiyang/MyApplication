package com.scu.xing.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by xing on 2017/8/9.
 */

public class GuangboActivity extends Activity{

    BCReceiver2 bc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guangboview);

        IntentFilter intentFilter = new IntentFilter("BC_One");
        bc = new BCReceiver2();
        registerReceiver(bc,intentFilter);

        initEvent();
    }

    private void initEvent(){

        findViewById(R.id.button46).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNormal();
            }
        });

        findViewById(R.id.button48).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOrder();
            }
        });

        findViewById(R.id.button49).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendAjax();
            }
        });
    }

    private void sendNormal(){

        Intent intent = new Intent();
        intent.putExtra("msg","这是一条普通广播");
        intent.setAction("BC_One");
        sendBroadcast(intent);
    }

    private void sendOrder(){

        Intent intent = new Intent();
        intent.putExtra("msg","这是一条有序广播");
        intent.setAction("BC_One");
        sendOrderedBroadcast(intent,null);
    }

    private void sendAjax(){

        Intent intent = new Intent();
        intent.putExtra("msg","这是一条异步广播");
        intent.setAction("BC_Three");
        sendStickyBroadcast(intent);
        Log.i("info","ccc");
        IntentFilter intentFilter3 = new IntentFilter("BC_Three");
        BCReceiver3 bc = new BCReceiver3();
        registerReceiver(bc,intentFilter3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bc);
    }
}
