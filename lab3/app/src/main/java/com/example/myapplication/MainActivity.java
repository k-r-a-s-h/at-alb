package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String[] mobileArray = {
            "Android",
            "IPhone",
            "WindowsMobile",
            "Blackberry",
            "WebOS",
            "Ubuntu",
            "Windows7","" +
            "Max OS X"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.mobile_list);
        ListAdapter adapter = new ListAdapter(MainActivity.this, mobileArray);
        listView.setAdapter(adapter);

    }


}
