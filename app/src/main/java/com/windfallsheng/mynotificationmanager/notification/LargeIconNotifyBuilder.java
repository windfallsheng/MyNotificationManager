package com.windfallsheng.mynotificationmanager.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

/**
 * @author lzsheng
 */

public class LargeIconNotifyBuilder extends BaseNotifyBuilder {

    public int largeIcon;

    protected NotificationCompat.Builder notifyBuilder;


    public LargeIconNotifyBuilder(DefaultNotifyBuilder defaultBuilder) {
        super(defaultBuilder);
    }

    public LargeIconNotifyBuilder setLargeIcon(int largeIcon) {
        this.largeIcon = largeIcon;
        return this;
    }

    @Override
    public Notification build(Context context) {
        super.build(context);
        if (largeIcon > 0) {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inSampleSize = 2;
            Bitmap bmLargeIcon = BitmapFactory.decodeResource(context.getResources(),
                    largeIcon, options);
            notifyBuilder.setLargeIcon(bmLargeIcon)
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(bmLargeIcon)
                            .bigLargeIcon(null));
        }
        return notifyBuilder.build();
    }
}
