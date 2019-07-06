package com.windfallsheng.mynotificationmanager.notification;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * @author lzsheng
 */

public class BigTextNotifyBuilder extends BaseNotifyBuilder{

    public String mBigText;
    public NotificationCompat.BigTextStyle mBigTextStyle;

    public NotificationCompat.Builder getDefaultBuilder() {
        return notifyBuilder;
    }

    protected NotificationCompat.Builder notifyBuilder;


    public BigTextNotifyBuilder(DefaultNotifyBuilder defaultBuilder) {
        super(defaultBuilder);
    }

    public BigTextNotifyBuilder setBigText(String bigText) {
        this.mBigText = bigText;
        mBigTextStyle = new NotificationCompat.BigTextStyle()
                .bigText(bigText);
        return this;
    }

    @Override
    public Notification build(Context context) {
        super.build(context);
        notifyBuilder.setStyle(mBigTextStyle);
        return notifyBuilder.build();
    }
}
