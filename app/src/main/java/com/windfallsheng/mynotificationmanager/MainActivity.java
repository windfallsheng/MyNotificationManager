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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = MainActivity.class.getSimpleName();
    TextView tvImMsg, tvSysMsg;
    private String userArray[] = {"Cyra", "Morgen", "Iris", "Mia"};
    private String messageArray[] = {"我发表了新的美食文章", "我更新了我的相册", "我在FaceBook申请了账号", "我做了一个好看的小视频"};
    private String sysMessageArray[] = {"有新的系统版本可以升级", "收到新的资讯内容", "为你推荐周边美食、娱乐活动", "最新最火爆的游戏"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvImMsg = findViewById(R.id.textview_im_msg);
        tvSysMsg = findViewById(R.id.textview_sys_msg);

        tvImMsg.setOnClickListener(this);
        tvSysMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textview_im_msg:
                notifyImMessage();
                break;
            case R.id.textview_sys_msg:
                notifySysMessage();
                break;
            default:
                break;
        }
    }

    private void notifyImMessage() {
        int uIndex = (int) (Math.random() * userArray.length);
        int mIndex = (int) (Math.random() * messageArray.length);
        String userName = userArray[uIndex];
        String content = messageArray[mIndex];
        String key = "ImMessage#" + userName;
        int requestCode = NotifyManager.getInstance(MainActivity.this).initNotifyId(key);
        Log.d(TAG, "method:notifyReceivedMessage#key=" + key + ", requestCode=" + requestCode);
        Intent intent = new Intent(MainActivity.this, NotificationMsgActivity.class);
        intent.putExtra("msgContent", userName + ":\n\n" + content);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        DefaultNotifyBuilder defaultNotifyBuilder = new DefaultNotifyBuilder(userName, content)
                .setChannelId(getResources().getString(R.string.channel_001))
                .setContentIntent(pendingIntent);
        NotifyManager.getInstance(MainActivity.this).showDefaultNotification(key, defaultNotifyBuilder);
    }

    private void notifySysMessage() {
        String key = "SysMessage#系统消息";
        int mIndex = (int) (Math.random() * sysMessageArray.length);
        String content = sysMessageArray[mIndex];
        int requestCode = NotifyManager.getInstance(MainActivity.this).initNotifyId(key);
        Log.d(TAG, "method:notifyReceivedMessage#key=" + key + ", requestCode=" + requestCode);
        Intent intent = new Intent(MainActivity.this, NotificationMsgActivity.class);
        intent.putExtra("msgContent", "系统消息" + ":\n\n" + content);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        DefaultNotifyBuilder defaultNotifyBuilder = new DefaultNotifyBuilder("系统消息", content)
                .setChannelId(getResources().getString(R.string.channel_002))
                .setContentIntent(pendingIntent);
        NotifyManager.getInstance(MainActivity.this).showDefaultNotification(key, defaultNotifyBuilder);
    }

}
