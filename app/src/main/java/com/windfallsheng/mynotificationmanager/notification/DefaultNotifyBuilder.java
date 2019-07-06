package com.windfallsheng.mynotificationmanager.notification;

import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;

import com.windfallsheng.mynotificationmanager.R;

/**
 * @author luzhaosheng
 */

public class DefaultNotifyBuilder {

    public String mChannelId;
    public int mSmallIcon = R.drawable.ic_launcher_foreground;
    public CharSequence mContentTitle = "小蜗牛Tech";
    public CharSequence mContentText;
    public CharSequence mTicker = "小蜗牛Tech";
    public int flag = NotificationCompat.FLAG_AUTO_CANCEL;
    public int priority = NotificationCompat.PRIORITY_HIGH;
    public long mWhen = System.currentTimeMillis();
    public PendingIntent mContentIntent;
    public boolean sound;
    public boolean vibrate;
    public boolean lights;

    public NotificationCompat.Builder getNotifyBuilder() {
        return notifyBuilder;
    }

    protected NotificationCompat.Builder notifyBuilder;

    public DefaultNotifyBuilder(CharSequence contentText) {
        this.mContentText = contentText;
    }

    public DefaultNotifyBuilder(CharSequence contentTitle, CharSequence contentText) {
        this.mContentTitle = contentTitle;
        this.mContentText = contentText;
    }

    public DefaultNotifyBuilder(int smallIcon, CharSequence contentTitle, CharSequence contentText) {
        this.mSmallIcon = smallIcon;
        this.mContentTitle = contentTitle;
        this.mContentText = contentText;
    }

    public DefaultNotifyBuilder setChannelId(String channelId) {
        this.mChannelId = channelId;
        return this;
    }

    public DefaultNotifyBuilder setTicker(CharSequence ticker) {
        this.mTicker = ticker;
        return this;
    }

    public DefaultNotifyBuilder setFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public DefaultNotifyBuilder setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public DefaultNotifyBuilder setWhen(long when) {
        this.mWhen = when;
        return this;
    }

    public DefaultNotifyBuilder setContentIntent(PendingIntent contentIntent) {
        this.mContentIntent = contentIntent;
        return this;
    }

    public DefaultNotifyBuilder setSound(boolean sound) {
        this.sound = sound;
        return this;
    }

    public DefaultNotifyBuilder setVibrate(boolean vibrate) {
        this.vibrate = vibrate;
        return this;
    }

    public DefaultNotifyBuilder setLights(boolean lights) {
        this.lights = lights;
        return this;
    }
}
