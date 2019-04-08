package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter {
    private ArrayList<String> a ;
    private Context c;
//    String a
    public  CustomAdaptor(Context c ,ArrayList<String> strings){
        this.c=c;
        this.a=strings;
    }
    @Override
    public int getCount() {
        return a.size();
    }

    @Override
    public Object getItem(int position) {
        return a.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(c).inflate(R.layout.lv,parent,false );
        }

        TextView tv=convertView.findViewById(R.id.textView);
        tv.setText(a.get(position));

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,a.get(position), Toast.LENGTH_LONG ).show();
            }
        });

        return convertView;

    }
}
