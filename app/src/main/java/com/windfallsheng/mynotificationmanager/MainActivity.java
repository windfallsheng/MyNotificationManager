package com.windfallsheng.mynotificationmanager;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.windfallsheng.mynotificationmanager.notification.DefaultNotifyBuilder;
import com.windfallsheng.mynotificationmanager.notification.NotifyManager;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = MainActivity.class.getSimpleName();

    TextView tvCreate, tvDefer, tvJust, tvFromIterable, tvTimer, tvFromArray, tvInterval, tvIntervalRange, tvRange;
    int countSys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCreate = findViewById(R.id.textview_create);
        tvDefer = findViewById(R.id.textview_defer);
        tvJust = findViewById(R.id.textview_just);
        tvFromIterable = findViewById(R.id.textview_fromiterable);
        tvTimer = findViewById(R.id.textview_timer);
        tvFromArray = findViewById(R.id.textview_fromarray);
        tvInterval = findViewById(R.id.textview_interval);
        tvIntervalRange = findViewById(R.id.textview_intervalrange);
        tvRange = findViewById(R.id.textview_range);

        tvCreate.setOnClickListener(this);
        tvDefer.setOnClickListener(this);
        tvJust.setOnClickListener(this);
        tvFromIterable.setOnClickListener(this);
        tvTimer.setOnClickListener(this);
        tvFromArray.setOnClickListener(this);
        tvInterval.setOnClickListener(this);
        tvIntervalRange.setOnClickListener(this);
        tvRange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textview_create:
                userAAAImMsg();
                break;
            case R.id.textview_defer:
                userBBBImMsg();
                break;
            case R.id.textview_just:
                userCCCImMsg();
                break;
            case R.id.textview_fromiterable:
                sysAAAMsg();
                break;
            case R.id.textview_timer:
//                sysBBBMsg();
                break;
            case R.id.textview_fromarray:
//                fromArray();
                break;
            case R.id.textview_interval:
//                interval();
                break;
            case R.id.textview_intervalrange:
//                intervalRange();
                break;
            case R.id.textview_range:
//                range();
                break;
            default:
                break;
        }
    }

    private void userAAAImMsg() {
        Intent intent = new Intent(MainActivity.this, NotificationMsgActivity.class);
        ;
//        if (String.valueOf(com.icbc.constans.Constants.LOGISTICS_INFO_IM_ID).equals(chatId)) {
//            intent = new Intent(mContext, LogisticsListActivity.class);
//        } else if (String.valueOf(com.icbc.constans.Constants.SERVICE_MSG_IM_ID).equals(chatId)) {
//            intent = new Intent(mContext, ServiceInfoListActivity.class);
//        } else {
//            intent = new Intent(mContext, ChatMessageListActivity.class);
//            intent.putExtra(com.icbc.constans.Constants.FLAG_FROM_PAGE, com.icbc.constans.Constants.FLAG_FROM_CHAT_SESSION_LIST_ACTIVITY);
//            intent.putExtra(com.icbc.constans.Constants.CHAT_INFO_ENTITY, (Serializable) chatInfoEntity);
//        }
//        LogUtils.d(TAG, "method:notifyReceivedMessage#notifyBuilder=" + notifyBuilder + ", intent=" + intent);
        String key = "ImMessage#AAA";
        int requestCode = NotifyManager.getInstance(MainActivity.this).initNotifyId(key);
        Log.d(TAG, "method:notifyReceivedMessage#key=" + key + ", requestCode=" + requestCode);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        DefaultNotifyBuilder defaultNotifyBuilder = new DefaultNotifyBuilder("收到新的IM消息 from:" + key)
                .setChannelId(getResources().getString(R.string.groupId_002))
                .setContentIntent(pendingIntent);
        NotifyManager.getInstance(MainActivity.this).showDefaultNotification(key, defaultNotifyBuilder);
    }

    private void userBBBImMsg() {
        Intent intent = new Intent(MainActivity.this, NotificationMsgActivity.class);
        ;
//        if (String.valueOf(com.icbc.constans.Constants.LOGISTICS_INFO_IM_ID).equals(chatId)) {
//            intent = new Intent(mContext, LogisticsListActivity.class);
//        } else if (String.valueOf(com.icbc.constans.Constants.SERVICE_MSG_IM_ID).equals(chatId)) {
//            intent = new Intent(mContext, ServiceInfoListActivity.class);
//        } else {
//            intent = new Intent(mContext, ChatMessageListActivity.class);
//            intent.putExtra(com.icbc.constans.Constants.FLAG_FROM_PAGE, com.icbc.constans.Constants.FLAG_FROM_CHAT_SESSION_LIST_ACTIVITY);
//            intent.putExtra(com.icbc.constans.Constants.CHAT_INFO_ENTITY, (Serializable) chatInfoEntity);
//        }
//        LogUtils.d(TAG, "method:notifyReceivedMessage#notifyBuilder=" + notifyBuilder + ", intent=" + intent);
        String key = "ImMessage#BBB";
        int requestCode = NotifyManager.getInstance(MainActivity.this).initNotifyId(key);
        Log.d(TAG, "method:notifyReceivedMessage#key=" + key + ", requestCode=" + requestCode);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        DefaultNotifyBuilder defaultNotifyBuilder = new DefaultNotifyBuilder("收到新的IM消息 from:" + key)
                .setChannelId(getResources().getString(R.string.groupId_002))
                .setContentIntent(pendingIntent);
        NotifyManager.getInstance(MainActivity.this).showDefaultNotification(key, defaultNotifyBuilder);
    }

    private void userCCCImMsg() {
        Intent intent = new Intent(MainActivity.this, NotificationMsgActivity.class);
        ;
//        if (String.valueOf(com.icbc.constans.Constants.LOGISTICS_INFO_IM_ID).equals(chatId)) {
//            intent = new Intent(mContext, LogisticsListActivity.class);
//        } else if (String.valueOf(com.icbc.constans.Constants.SERVICE_MSG_IM_ID).equals(chatId)) {
//            intent = new Intent(mContext, ServiceInfoListActivity.class);
//        } else {
//            intent = new Intent(mContext, ChatMessageListActivity.class);
//            intent.putExtra(com.icbc.constans.Constants.FLAG_FROM_PAGE, com.icbc.constans.Constants.FLAG_FROM_CHAT_SESSION_LIST_ACTIVITY);
//            intent.putExtra(com.icbc.constans.Constants.CHAT_INFO_ENTITY, (Serializable) chatInfoEntity);
//        }
//        LogUtils.d(TAG, "method:notifyReceivedMessage#notifyBuilder=" + notifyBuilder + ", intent=" + intent);
        String key = "ImMessage#CCC";
        int requestCode = NotifyManager.getInstance(MainActivity.this).initNotifyId(key);
        Log.d(TAG, "method:notifyReceivedMessage#key=" + key + ", requestCode=" + requestCode);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        DefaultNotifyBuilder defaultNotifyBuilder = new DefaultNotifyBuilder("收到新的IM消息 from:" + key)
                .setChannelId(getResources().getString(R.string.groupId_002))
                .setContentIntent(pendingIntent);
        NotifyManager.getInstance(MainActivity.this).showDefaultNotification(key, defaultNotifyBuilder);
    }

    private void sysAAAMsg() {
        String key = "sysMessage#AAA";
        Intent intent = new Intent(MainActivity.this, NotificationMsgActivity.class);
        intent.putExtra("Msg", key + "_" + countSys++);
//        if (String.valueOf(com.icbc.constans.Constants.LOGISTICS_INFO_IM_ID).equals(chatId)) {
//            intent = new Intent(mContext, LogisticsListActivity.class);
//        } else if (String.valueOf(com.icbc.constans.Constants.SERVICE_MSG_IM_ID).equals(chatId)) {
//            intent = new Intent(mContext, ServiceInfoListActivity.class);
//        } else {
//            intent = new Intent(mContext, ChatMessageListActivity.class);
//            intent.putExtra(com.icbc.constans.Constants.FLAG_FROM_PAGE, com.icbc.constans.Constants.FLAG_FROM_CHAT_SESSION_LIST_ACTIVITY);
//            intent.putExtra(com.icbc.constans.Constants.CHAT_INFO_ENTITY, (Serializable) chatInfoEntity);
//        }
//        LogUtils.d(TAG, "method:notifyReceivedMessage#notifyBuilder=" + notifyBuilder + ", intent=" + intent);
        int requestCode = NotifyManager.getInstance(MainActivity.this).initNotifyId(key);
        Log.d(TAG, "method:notifyReceivedMessage#key=" + key + ", requestCode=" + requestCode);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        DefaultNotifyBuilder defaultNotifyBuilder = new DefaultNotifyBuilder("收到新的IM消息 from:" + key)
                .setChannelId(getResources().getString(R.string.groupId_002))
                .setContentIntent(pendingIntent);
        NotifyManager.getInstance(MainActivity.this).showDefaultNotification(key, defaultNotifyBuilder);
    }

}
