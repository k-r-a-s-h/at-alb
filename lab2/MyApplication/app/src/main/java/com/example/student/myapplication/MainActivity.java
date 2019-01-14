package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void call(View view)
    {
        // Do something in response to button click
        Toast toast = Toast.makeText(getApplicationContext(),"details submitted",
                Toast.LENGTH_SHORT);
        toast.show();

    }

}
