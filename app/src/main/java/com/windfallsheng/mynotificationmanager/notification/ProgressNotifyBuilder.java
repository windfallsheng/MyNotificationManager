package com.windfallsheng.mynotificationmanager.notification;

import android.app.Notification;
import android.content.Context;

/**
 * @author luzhaosheng
 */
public class ProgressNotifyBuilder extends BaseNotifyBuilder {

    public int max;
    public int progress;
    public boolean interminate;


    public ProgressNotifyBuilder(DefaultNotifyBuilder defaultBuilder) {
        super(defaultBuilder);
    }

    public ProgressNotifyBuilder setMax(int max) {
        this.max = max;
        return this;
    }

    public ProgressNotifyBuilder setProgress(int progress) {
        this.progress = progress;
        return this;
    }

    public ProgressNotifyBuilder setInterminate(boolean interminate) {
        this.interminate = interminate;
        return this;
    }

    @Override
    public Notification build(Context context) {
        super.build(context);
        notifyBuilder.setProgress(max, progress, interminate);
        notifyBuilder.setContentText(progress / max + "%");
        return notifyBuilder.build();
    }

}
