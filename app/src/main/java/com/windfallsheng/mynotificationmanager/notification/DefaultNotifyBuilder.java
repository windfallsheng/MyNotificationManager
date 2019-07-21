package com.windfallsheng.mynotificationmanager.notification;

import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;

import com.windfallsheng.mynotificationmanager.R;

/**
 * @author lzsheng
 */

public class DefaultNotifyBuilder {

    public String channelId;
    public int smallIcon = R.drawable.ic_launcher_foreground;
    public CharSequence contentTitle = "小蜗牛Tech";
    public CharSequence contentText;
    public CharSequence ticker;
    public int flag = NotificationCompat.FLAG_AUTO_CANCEL;
    public int priority = NotificationCompat.PRIORITY_HIGH;
    public long when = System.currentTimeMillis();
    public PendingIntent contentIntent;
    public boolean autoCancel = true;
    public boolean sound;
    public boolean vibrate;
    public boolean lights;

    public DefaultNotifyBuilder(CharSequence contentText) {
        this.contentText = contentText;
    }

    public DefaultNotifyBuilder(CharSequence contentTitle, CharSequence contentText) {
        this.contentTitle = contentTitle;
        this.contentText = contentText;
    }

    public DefaultNotifyBuilder(int smallIcon, CharSequence contentTitle, CharSequence contentText) {
        this.smallIcon = smallIcon;
        this.contentTitle = contentTitle;
        this.contentText = contentText;
    }

    public DefaultNotifyBuilder setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public DefaultNotifyBuilder setTicker(CharSequence ticker) {
        this.ticker = ticker;
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
        this.when = when;
        return this;
    }

    public DefaultNotifyBuilder setContentIntent(PendingIntent contentIntent) {
        this.contentIntent = contentIntent;
        return this;
    }

    public DefaultNotifyBuilder setAutoCancel(boolean autoCancel) {
        this.autoCancel = autoCancel;
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
