package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "NOTIFICATION_CHANNEL",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("TEMPORARY DESC");
            mNotificationManager.createNotificationChannel(channel);
        }

    }

    public void generate(View view) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "default")
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Teastnskgven ")
                .setContentText("bdsjgbakjedsbrgjnberlknhkqe")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        mNotificationManager.notify(0, mBuilder.build());
                Toast.makeText(this ,"Working",Toast.LENGTH_SHORT).show();
    }

}
