package com.scu.xing.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by xing on 2017/8/7.
 */

public class CalculateActivity extends Activity implements View.OnClickListener{

    private Button bt15;
    private Button bt16;
    private Button bt17;
    private Button bt18;
    private Button bt19;
    private Button bt20;
    private Button bt21;
    private Button bt22;
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caculate_view);

        bt15 = (Button)findViewById(R.id.button15);
        bt16 = (Button)findViewById(R.id.button16);
        bt17 = (Button)findViewById(R.id.button17);
        bt18 = (Button)findViewById(R.id.button18);
        bt19 = (Button)findViewById(R.id.button19);
        bt20 = (Button)findViewById(R.id.button20);
        bt21 = (Button)findViewById(R.id.button21);
        bt22 = (Button)findViewById(R.id.button22);
        editText = (EditText)findViewById(R.id.editText);

        bt15.setOnClickListener(this);
        bt16.setOnClickListener(this);
        bt17.setOnClickListener(this);
        bt18.setOnClickListener(this);
        bt19.setOnClickListener(this);
        bt20.setOnClickListener(this);
        bt21.setOnClickListener(this);
        bt22.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String str = editText.getText().toString();
        switch (view.getId()){
            case R.id.button15:
            case R.id.button16:
            case R.id.button17:
            case R.id.button18:
            case R.id.button21:
            case R.id.button22:
                editText.setText(str+((Button)view).getText());
                break;
            case R.id.button19:
                //delete
                editText.setText("");
                break;
            case R.id.button20:
                //cancel
                if(str != null && !str.equals("")){
                    editText.setText(str.substring(0,str.length()-1));
                }else{
                    editText.setText("");
                }
                break;
            default:
                break;
        }
    }
}
