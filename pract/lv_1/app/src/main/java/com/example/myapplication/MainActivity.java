package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);

        ArrayList<String> s=new ArrayList<String>();

        s.add("Hello");
        s.add("Yooo");
        s.add("Ashwath");
        s.add("LOLLOLOLO");

        CustomAdaptor cs=new CustomAdaptor(this, s);
        lv.setAdapter(cs);
    }
}
