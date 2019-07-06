package com.windfallsheng.mynotificationmanager.notification;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.windfallsheng.mynotificationmanager.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lzsheng
 * <p>
 * 封装通知栏实现，对于某些相关属性的处理逻辑，可根据具体的需求调整完善
 */
public class NotifyManager {
    private static final String TAG = NotifyManager.class.getSimpleName();
    private static NotifyManager sInstance = null;
    private static NotificationManager mNotificationManager;
    private static List<NotificationChannelGroup> mChannelGroupList;
    /**
     * 通知栏的消息对象的自增Id
     */
    private AtomicInteger mInitialNotifyId = new AtomicInteger(0);
    /**
     * 全局通知栏的Id，不同消息对象，对应自身唯一的全局Id
     */
    private volatile Map<Object, Integer> mGlobalNotifyIdMap;

    private static Context mContext;

    private NotifyManager() {
    }

    public static NotifyManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (NotifyManager.class) {
                if (sInstance == null) {
                    sInstance = new NotifyManager();
                    mContext = context.getApplicationContext();
                    if (mNotificationManager == null) {
                        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
                        initNotifyChannel();
                    }
                }
            }
        }
        return sInstance;
    }

    private static void initNotifyChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (mChannelGroupList == null) {
                mChannelGroupList = new ArrayList<>();
            }
            mChannelGroupList.add(new NotificationChannelGroup(mContext.getResources().getString(R.string.groupId_001), "系统消息"));
            mChannelGroupList.add(new NotificationChannelGroup(mContext.getResources().getString(R.string.groupId_002), "IM消息"));
            mNotificationManager.createNotificationChannelGroups(mChannelGroupList);
            NotificationChannel channel1 = new NotificationChannel(mContext.getResources().getString(R.string.channel_001), "系统消息", NotificationManager.IMPORTANCE_HIGH);
            NotificationChannel channel2 = new NotificationChannel(mContext.getResources().getString(R.string.channel_002), "IM消息", NotificationManager.IMPORTANCE_HIGH);
            channel1.setGroup(mContext.getResources().getString(R.string.groupId_001));
            channel2.setGroup(mContext.getResources().getString(R.string.groupId_002));
            mNotificationManager.createNotificationChannel(channel1);
            mNotificationManager.createNotificationChannel(channel2);
        }
    }

    public int getInitialNotifyId() {
        if (mInitialNotifyId != null) {
            return mInitialNotifyId.intValue();
        }
        return 0;
    }

    public Map<Object, Integer> getGlobalNotifyIdMap() {
        return mGlobalNotifyIdMap;
    }

    /**
     * IM消息的key的形式：key = "ImMessage" 
     *
     * @param key
     * @return 返回对应的id
     */
    public int initNotifyId(Object key) {
        Log.d(TAG, "method:initNotifyId#key=" + key);
        if (mGlobalNotifyIdMap == null) {
            mGlobalNotifyIdMap = new HashMap<>();
        }
        Integer notifyId = mGlobalNotifyIdMap.get(key);
        Log.d(TAG, "method:initNotifyId#mGlobalNotifyIdMap=" + mGlobalNotifyIdMap);
        Log.d(TAG, "method:initNotifyId#notifyId=" + notifyId);
        if (notifyId == null) {
            return putNotifyId(key);
        } else {
            return notifyId;
        }
    }

    /**
     * 保证每次往集合{@link #mGlobalNotifyIdMap}中put新值时，ID都是自增的
     * <p>
     * IM消息的key的形式：key = "ImMessage" 
     *
     * @param key
     * @return
     */
    private int putNotifyId(Object key) {
        Log.d(TAG, "method:putNotifyId#key=" + key);
        if (mGlobalNotifyIdMap != null) {
            int value = mInitialNotifyId.incrementAndGet();
            Log.d(TAG, "method:putNotifyId#mInitialNotifyId.incrementAndGet#value=" + value);
            mGlobalNotifyIdMap.put(key, value);
            Log.d(TAG, "method:putNotifyId#mGlobalNotifyIdMap=" + mGlobalNotifyIdMap);
            return value;
        }
        return 0;
    }

    private void notify(Object key, BaseNotifyBuilder builder) {
        int notifyId = initNotifyId(key);
        mNotificationManager.notify(notifyId, builder.build(mContext));
    }

    public NotificationManager getNotificationManager() {
        return mNotificationManager;
    }

    public List<NotificationChannelGroup> getChannelGroupList() {
        return mChannelGroupList;
    }

    public void showDefaultNotification(Object key, DefaultNotifyBuilder defaultBuilder) {
        BaseNotifyBuilder builder = new BaseNotifyBuilder(defaultBuilder);
        notify(key, builder);
    }

    public void showProgressNotification(Object key, int progress, int max, boolean interminate, DefaultNotifyBuilder defaultBuilder) {
        ProgressNotifyBuilder builder = new ProgressNotifyBuilder(defaultBuilder);
        notify(key, builder);
    }

    public void showLargeIconNotification(Object key, int largeIconId, DefaultNotifyBuilder defaultBuilder) {
        LargeIconNotifyBuilder builder = new LargeIconNotifyBuilder(defaultBuilder).setLargeIcon(largeIconId);
        notify(key, builder);
    }

    public void showBigTextNotification(Object key, String bigText, DefaultNotifyBuilder defaultBuilder) {
        BigTextNotifyBuilder builder = new BigTextNotifyBuilder(defaultBuilder).setBigText(bigText);
        notify(key, builder);
    }

    // ……………… 根据需要完善其它通知栏样式 ………………
}
