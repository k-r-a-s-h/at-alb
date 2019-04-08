package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ArrayAdapter extends BaseAdapter {
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    Context context;
    ArrayAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return mobileArray.length;
    }

    @Override
    public Object getItem(int position) {
        return mobileArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.lv_def, parent,false);
        }

        final String item=(String) getItem(position);
        TextView tv=convertView.findViewById(R.id.textView2);
        tv.setText(item);

        return convertView;
    }
}
