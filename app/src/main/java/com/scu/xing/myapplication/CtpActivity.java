package com.scu.xing.myapplication;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by xing on 2017/8/9.
 */

public class CtpActivity extends Activity{

    private Button button43;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctpview);

        button43 = (Button) findViewById(R.id.button43);
        button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readContact();
            }
        });

    }

    private void readContact(){

        String cid = Contacts._ID;
        String cname = Contacts.DISPLAY_NAME;
        String[] array = {cid,cname};
        String[] arraynum = {Phone.NUMBER, Phone.TYPE};
        String[] arrayemail = {Email.DATA,Email.TYPE};

        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(Contacts.CONTENT_URI,array,null,null,null);
        if(c!=null){
            while (c.moveToNext()){
                int id = c.getInt(c.getColumnIndex(cid));
                Log.i("info","id: "+id);
                Log.i("info","name: "+c.getString(c.getColumnIndex(cname)));
                Cursor c1 = cr.query(Phone.CONTENT_URI,arraynum, Phone.CONTACT_ID+"="+id,null,null);
                //根据id查询号码
                if(c1!=null){
                    while (c1.moveToNext()){
                        int type = c1.getInt(c1.getColumnIndex(Phone.TYPE));
                        if(type == Phone.TYPE_HOME){
                            Log.i("info","home number: "+c1.getString(c1.getColumnIndex(Phone.NUMBER)));

                        }else if(type == Phone.TYPE_MOBILE){
                            Log.i("info","mobile number: "+c1.getString(c1.getColumnIndex(Phone.NUMBER)));
                        }
                    }
                    c1.close();
                }
                //根据id查询邮箱
                Cursor c2 = cr.query(Email.CONTENT_URI,arrayemail, Email.CONTACT_ID+"="+id,null,null);
                if(c2 != null){
                    while (c2.moveToNext()){
                        int type = c2.getInt(c2.getColumnIndex(Email.TYPE));
                        if(type == Email.TYPE_WORK){
                            Log.i("info","email work: "+c2.getString(c2.getColumnIndex(Email.DATA)));
                        }
                    }
                    c2.close();
                }
            }
            c.close();
        }

    }
}
