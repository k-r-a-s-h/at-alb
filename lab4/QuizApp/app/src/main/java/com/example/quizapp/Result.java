package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView correct, incorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        correct = (TextView) findViewById(R.id.textView5);
        incorrect = (TextView) findViewById(R.id.textView7);
        Intent intent = getIntent();
        String message = intent.getStringExtra("QUIZ_SCORE");
        int correct_count = Integer.parseInt(message);
        correct.setText(message);
        incorrect.setText(Integer.toString(3-correct_count));
    }
}
