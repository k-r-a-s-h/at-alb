package com.example.intentnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class alertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name= intent.getStringExtra("Result");
        Notificatio

    }
}
