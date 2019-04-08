package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private  Context context;
    private ArrayList<Item> items;
    public CustomListAdapter(Context context, ArrayList<Item> items){
        this.context=context;
        this.items=items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.layout_lv_row_items,parent,false );
        }
        final Item current_item =(Item)getItem(position);
        TextView textViewName=(TextView)convertView.findViewById(R.id.text_view_item_name);
        TextView textViewDescription=(TextView)convertView.findViewById(R.id.text_view_item_description);
        textViewName.setText(current_item.getItemName());
        textViewDescription.setText(current_item.getItemDescription());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, current_item.getItemDescription(), Toast.LENGTH_LONG).show();
            }
        });

        textViewDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, current_item.getItemName(), Toast.LENGTH_LONG).show();;
            }
        });
        return convertView;
    }
}
