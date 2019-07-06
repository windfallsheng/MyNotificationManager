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
    public String mChannelId;
    public DefaultNotifyBuilder mDefaultBuilder;
    public NotificationCompat.Style style;

    protected NotificationCompat.Builder notifyBuilder;


    public BaseNotifyBuilder(@NonNull DefaultNotifyBuilder defaultBuilder) {
        if (defaultBuilder == null) {
            throw new IllegalArgumentException("defaultNotifyBuilder = null");
        }
        this.mDefaultBuilder = defaultBuilder;
        mChannelId = defaultBuilder.mChannelId;
    }

    public BaseNotifyBuilder setStyle(NotificationCompat.Style style) {
        this.style = style;
        return this;
    }

    public Notification build(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notifyBuilder = new NotificationCompat.Builder(context, mChannelId);
        } else {
            notifyBuilder = new NotificationCompat.Builder(context);
        }
        Log.d(TAG, "method:build#mDefaultBuilder=" + mDefaultBuilder);
        if (mDefaultBuilder != null) {
            if (mDefaultBuilder.mSmallIcon > 0) {
                notifyBuilder.setSmallIcon(mDefaultBuilder.mSmallIcon);// 设置顶部状态栏的小图标
            }
            if (!TextUtils.isEmpty(mDefaultBuilder.mContentTitle)) {
                notifyBuilder.setContentTitle(mDefaultBuilder.mContentTitle);// 设置通知中心的标题
            }
            if (!TextUtils.isEmpty(mDefaultBuilder.mContentText)) {
                notifyBuilder.setContentText(mDefaultBuilder.mContentText);// 设置通知中心中的内容
            }
            PendingIntent contentIntent = mDefaultBuilder.mContentIntent;
            if (contentIntent != null) {
                notifyBuilder.setContentIntent(contentIntent);
            }
            int defaults =0;
            boolean sound = mDefaultBuilder.sound;
            boolean vibrate = mDefaultBuilder.vibrate;
            boolean lights = mDefaultBuilder.lights;
            if (sound) {
                defaults |= Notification.DEFAULT_SOUND;
            }
            if (vibrate) {
                defaults |= Notification.DEFAULT_VIBRATE;
            }
            if (lights) {
                defaults |= Notification.DEFAULT_LIGHTS;
            }
            if (defaults != 0){
                notifyBuilder.setDefaults(defaults);
            }
        }
        notifyBuilder.setTicker(mDefaultBuilder.mTicker);
        notifyBuilder.setAutoCancel(true);
        notifyBuilder.setWhen(mDefaultBuilder.mWhen);
        notifyBuilder.setPriority(mDefaultBuilder.priority);
        return notifyBuilder.build();
    }

}
