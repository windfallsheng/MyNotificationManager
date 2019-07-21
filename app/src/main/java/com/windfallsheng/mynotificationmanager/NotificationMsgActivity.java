package com.windfallsheng.mynotificationmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class NotificationMsgActivity extends AppCompatActivity {

    private final String TAG = NotificationMsgActivity.class.getSimpleName();
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_msg);
        String msgContent = getIntent().getStringExtra("msgContent");
        Log.d(TAG, "method:onCreate#msgContent=" + msgContent);
        tvMsg = findViewById(R.id.tv_message);
        tvMsg.setText(msgContent);
    }
}
