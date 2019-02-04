package com.example.student.lab4_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.student.lab4_1.R.id.radio;
import static com.example.student.lab4_1.R.id.radioButton;
import static com.example.student.lab4_1.R.id.radioButton2;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simplealert(View view) {
    //    boolean result=true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quiz Confirmation");
        builder.setMessage("Do you want to subit this quiz ?");
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        RadioGroup a = (RadioGroup) findViewById(R.id.radiogrp);
                        switch(a.getCheckedRadioButtonId()) {
                            case R.id.radioButton:
                              {
                                    Intent intent = new Intent(MainActivity.this, newact.class);
                                intent.putExtra("result", "true");
                                startActivity(intent);
                                    // Pirates are the best
                                    break;}
                            case R.id.radioButton2:
                               {
                                    Intent intent = new Intent(MainActivity.this, newact.class);
                                    intent.putExtra("result", "false");
                                    startActivity(intent);
                                    // Ninjas rule
                                    break;}

                        }
//
//                        RadioGroup a = (RadioGroup) findViewById(R.id.radiogrp);
//                        int select = a.getCheckedRadioButtonId();
//                        String s1 = (RadioButton) findViewById(select);
//                        if (s1 == "Delhi") {
//                            right();
//                        } else if (s1 == "Mumbai") {
//                            wrong();
//                        } else
//                            nothing();

                    }
                });
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }



}
