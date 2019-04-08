package com.example.intentnotification;

import android.app.AlarmManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class displayActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String message=getIntent().getStringExtra("Result");
        b=findViewById(R.id.button);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker=new TimePickerFragement();
                timePicker.show(getSupportFragmentManager(), "time picker");

            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,hourOfDay );
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        setAlarm(c);

    }

    private void setAlarm(Calendar c){
        AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent=  new
    }
}
