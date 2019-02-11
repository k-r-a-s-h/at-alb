package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.intent.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        EditText q1 = (EditText) findViewById(R.id.editText2);
        EditText q2 = (EditText) findViewById(R.id.editText3);
        String message;
        String ans1 = q1.getText().toString().toLowerCase();
        String ans2 = q2.getText().toString().toLowerCase();

        if(ans1.equals("ans1") && ans2.equals("ans2")){
             message = "Both answers correct";
        }
        else if(ans1.equals("ans1") && !ans2 .equals("ans2")){
            message="1 right and  2 wrong";
        }
        else if(!ans1.equals("ans1") && ans2.equals("ans2")){
            message ="1 wrong and 2 right";
        }
        else{
            message= "both wrong";
        }
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
