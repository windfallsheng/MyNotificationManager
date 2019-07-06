package com.windfallsheng.mynotificationmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationMsgActivity extends AppCompatActivity {

    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_msg);
        String msg = getIntent().getStringExtra("Msg");
        tvMsg = findViewById(R.id.tv_message);
        tvMsg.setText(msg);
    }
}
