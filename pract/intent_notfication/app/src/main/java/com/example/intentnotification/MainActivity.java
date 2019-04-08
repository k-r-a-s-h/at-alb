package com.example.intentnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    Button submit;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final NotificationManager notificationManager;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
        submit=findViewById(R.id.submit);
        notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O){
            NotificationChannel channel =new NotificationChannel("default", "NOTIFICAION_CHANNEL", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Temprorary Desc");
            notificationManager.createNotificationChannel(channel);
        }

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String message=ed1.getText().toString();
                Intent intent=new Intent(MainActivity.this,displayActivity.class);
                intent.putExtra("Result", message);
                startActivity(intent);

                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),"default")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Notification from the app")
                        .setContentText(message);
                notificationManager.notify(0,builder.build());

            }
        });

    }
}
