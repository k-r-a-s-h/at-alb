package com.example.quizapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Button submit_btn;
    Switch ans1, ans2, ans3;

    private void showResult(){
        int count = 0;
        if(ans1.isChecked())
            count++;
        if(ans2.isChecked())
            count++;
        if(!ans3.isChecked())
            count++;
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("QUIZ_SCORE", Integer.toString(count));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit_btn = (Button) findViewById(R.id.button);
        ans1 = (Switch) findViewById(R.id.switch1);
        ans2 = (Switch) findViewById(R.id.switch2);
        ans3 = (Switch) findViewById(R.id.switch3);
        submit_btn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(final View arg0) {

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                        // set title
                        alertDialogBuilder.setTitle("Submit quiz?");

                        // set dialog message
                        alertDialogBuilder
                                .setMessage("Click yes to submit")
                                .setCancelable(false)
                                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        showResult();
                                    }
                                })
                                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // if this button is clicked, just close
                                        // the dialog box and do nothing
                                        dialog.cancel();
                                    }
                                });
                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        // show it
                        alertDialog.show();
                    }
                }

        );
    }
}
