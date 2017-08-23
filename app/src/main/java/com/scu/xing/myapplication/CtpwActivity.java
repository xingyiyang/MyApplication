package com.scu.xing.myapplication;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by xing on 2017/8/9.
 */

public class CtpwActivity extends Activity{

    private Button button45;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctpwview);

        button45 = (Button)findViewById(R.id.button45);
        button45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeContact();
            }
        });

    }

    private void writeContact(){

        ContentResolver cr = getContentResolver();
        ContentValues cv = new ContentValues();
        Uri uri = cr.insert(RawContacts.CONTENT_URI,cv);
        Long raw_contact_id = ContentUris.parseId(uri);

        //插入人名
        cv.clear();
        cv.put(StructuredName.RAW_CONTACT_ID,raw_contact_id);
        cv.put(StructuredName.DISPLAY_NAME,"张三三");
        cv.put(StructuredName.MIMETYPE,StructuredName.CONTENT_ITEM_TYPE);
        uri = cr.insert(Data.CONTENT_URI,cv);

        //插入电话号码
        cv.clear();
        cv.put(Phone.RAW_CONTACT_ID,raw_contact_id);
        cv.put(Phone.NUMBER,"13333333333");
        cv.put(Phone.MIMETYPE,Phone.CONTENT_ITEM_TYPE);
        uri = cr.insert(Data.CONTENT_URI,cv);
    }
}
