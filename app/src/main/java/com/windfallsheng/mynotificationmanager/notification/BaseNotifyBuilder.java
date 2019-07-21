package com.windfallsheng.mynotificationmanager.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

/**
 * @author lzsheng
 */
public class BaseNotifyBuilder {

    private static final String TAG = BaseNotifyBuilder.class.getSimpleName();
    protected DefaultNotifyBuilder defaultBuilder;
    protected NotificationCompat.Builder notifyBuilder;

    public BaseNotifyBuilder(@NonNull DefaultNotifyBuilder defaultBuilder) {
        if (defaultBuilder == null) {
            throw new IllegalArgumentException("defaultNotifyBuilder = null.");
        }
        this.defaultBuilder = defaultBuilder;
    }

    public Notification build(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notifyBuilder = new NotificationCompat.Builder(context, defaultBuilder.channelId);
        } else {
            notifyBuilder = new NotificationCompat.Builder(context);
        }
        Log.d(TAG, "method:build#defaultBuilder=" + defaultBuilder);
        // 设置顶部状态栏的小图标
        notifyBuilder.setSmallIcon(defaultBuilder.smallIcon);
        // 设置通知中心的标题
        notifyBuilder.setContentTitle(defaultBuilder.contentTitle);
        // 设置通知中心中的内容
        CharSequence contentText = defaultBuilder.contentText;
        if (!TextUtils.isEmpty(contentText)) {
            notifyBuilder.setContentText(defaultBuilder.contentText);
        }
        PendingIntent contentIntent = defaultBuilder.contentIntent;
        if (contentIntent != null) {
            notifyBuilder.setContentIntent(contentIntent);
        }
        int defaults = 0;
        boolean sound = defaultBuilder.sound;
        boolean vibrate = defaultBuilder.vibrate;
        boolean lights = defaultBuilder.lights;
        if (sound) {
            defaults |= Notification.DEFAULT_SOUND;
        }
        if (vibrate) {
            defaults |= Notification.DEFAULT_VIBRATE;
        }
        if (lights) {
            defaults |= Notification.DEFAULT_LIGHTS;
        }
        if (defaults != 0) {
            notifyBuilder.setDefaults(defaults);
        }
        CharSequence ticker = defaultBuilder.ticker;
        if (!TextUtils.isEmpty(ticker)) {
            notifyBuilder.setTicker(defaultBuilder.ticker);
        }
        notifyBuilder.setAutoCancel(defaultBuilder.autoCancel);
        notifyBuilder.setWhen(defaultBuilder.when);
        notifyBuilder.setPriority(defaultBuilder.priority);
        return notifyBuilder.build();
    }

}
