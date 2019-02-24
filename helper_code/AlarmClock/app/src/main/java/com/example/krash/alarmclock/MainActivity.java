package com.example.krash.alarmclock;

import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private EditText editTextTitle;
    private EditText editTextMessge;
    private Button buttonChannel1;
    private Button buttonChannel2;
    private NotificaionHelper mNotificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button) findViewById(R.id.button);


        editTextTitle= (EditText)findViewById(R.id.editText_title);
        editTextMessge= (EditText)findViewById(R.id.editText_message);
        buttonChannel1= (Button)findViewById(R.id.button_channel1);
        buttonChannel2= (Button)findViewById(R.id.button_channel2);
        mNotificationHelper = new NotificaionHelper(this);
        buttonChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1(editTextTitle.getText().toString(),editTextMessge.getText().toString());
            }
        });
        buttonChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2(editTextTitle.getText().toString(),editTextMessge.getText().toString());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timmePicker =new TimePickerFragment();
                timmePicker.show(getSupportFragmentManager(),"time picker");
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView =(TextView)findViewById(R.id.textView);
        textView.setText("Hour: "+hourOfDay+" Minute: "+minute);
    }
    public void sendOnChannel1(String title, String message){
        NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(title,message);
        mNotificationHelper.getManager().notify(1,nb.build());

    }
    public void sendOnChannel2(String title, String message){
        NotificationCompat.Builder nb = mNotificationHelper.getChannel2Notification(title,message);
        mNotificationHelper.getManager().notify(2,nb.build());

    }
}
