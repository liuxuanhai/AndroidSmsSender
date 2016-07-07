package com.zky.zhaoliang.androidsmssender;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

/**
 * Android 短信发送器
 */
public class MainActivity extends AppCompatActivity {

    private EditText etPhoneNum, etSmsContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
    }

    private void findView() {
        etPhoneNum = (EditText) findViewById(R.id.et_phonenum);
        etSmsContent = (EditText) findViewById(R.id.et_smscontent);
    }

    public void send(View view) {
        // 1.获取电话号码和短信内容
        String phoneNum = etPhoneNum.getText().toString().trim();
        String smsContent = etSmsContent.getText().toString().trim();
        // 2.获取发送短信的api
        SmsManager smsManager = SmsManager.getDefault();
        // 3.发送短信
        smsManager.sendMultipartTextMessage(phoneNum, null, smsManager.divideMessage(smsContent), null, null);
    }
}
