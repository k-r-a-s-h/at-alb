package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Item> itemArrayList=new ArrayList<Item>();
        Item i1=new Item("Krishna ", "He is a cunt");
        Item i2=new Item("Krishna Gupta ", "He is a lunt");
        Item i3=new Item("Krishna HOOHOH ", "He idgs;bs a cunt");
        itemArrayList.add(i1);
        itemArrayList.add(i2);
        itemArrayList.add(i3);
        CustomListAdapter adapter=new CustomListAdapter(this, itemArrayList);

        ListView itemListView=(ListView)findViewById(R.id.lv);
        itemListView.setAdapter(adapter);

        ArrayAdapter arrayAdapter =new ArrayAdapter(this);
        ListView lv=findViewById(R.id.array_lv);
        lv.setAdapter(arrayAdapter);




    }
}
