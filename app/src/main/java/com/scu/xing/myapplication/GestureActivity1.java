package com.scu.xing.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/9.
 */

public class GestureActivity1 extends Activity{

    private GestureDetector gestureDetector;
    class myGestureListsener extends SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if((e1.getX()-e2.getX())>50){
                Toast.makeText(GestureActivity1.this,"从右往左",Toast.LENGTH_SHORT).show();
            }else if((e2.getX()-e1.getX())>50){
                Toast.makeText(GestureActivity1.this,"从左往右",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(GestureActivity1.this,"无法识别",Toast.LENGTH_SHORT).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture1);
        initEvent();
    }

    private void initEvent(){

        gestureDetector = new GestureDetector(GestureActivity1.this,new myGestureListsener());
        findViewById(R.id.imageView3).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }
}
