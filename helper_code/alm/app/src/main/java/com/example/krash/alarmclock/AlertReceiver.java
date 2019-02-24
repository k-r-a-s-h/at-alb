package com.example.krash.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
       NotificaionHelper notificaionHelper = new NotificaionHelper(context);
       NotificationCompat.Builder nb = notificaionHelper.getChannel1Notification("titlr","message");
       notificaionHelper.getManager().notify(1,nb.build());
        try {

            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            Ringtone r = RingtoneManager.getRingtone(context,notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
