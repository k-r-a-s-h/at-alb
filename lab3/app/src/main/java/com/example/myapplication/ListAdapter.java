package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ListAdapter extends BaseAdapter {

    String [] mobileArray;
    LayoutInflater inflater;
    Context context;

    ListAdapter(Context context, String mobileArray[]){
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        this.mobileArray = mobileArray;
    }

    @Override
    public int getCount() {
        return mobileArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.activity_listview, parent, false);
        TextView textView = (TextView) view.findViewById(R.id.label);
        textView.setText(mobileArray[position]);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mobileArray[position].toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
