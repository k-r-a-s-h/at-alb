package com.example.student.lab4_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.student.lab4_1.R.id.textView;

public class newact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newact);

           // Intent intent = getIntent();
            String message = getIntent().getExtras().getString("result");
            // Capture the layout's TextView and set the string as its text
            if(message.equals("true")){
            TextView textView =(TextView) findViewById(R.id.textView);
             textView.setText("You passed");}
                else if (message.equals("false")){
                    TextView textView = (TextView)findViewById(R.id.textView);
                    textView.setText("You failed");
                }

}
}
