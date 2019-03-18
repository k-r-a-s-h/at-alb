package com.example.invoicemachine;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static com.example.invoicemachine.MainActivity.mydb;

public class viewminmax extends AppCompatActivity {
    int num;
//    int max_cost;
//    int min_cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewminmax);
        num=0;

        Cursor data = mydb.getAllData();
        StringBuffer buffer=new StringBuffer();
        while (data.moveToNext()){
            if(data.getString(3).length()>0){
                num++;
            }
        }
        buffer.append("=====Max=====\n");
        Cursor max=mydb.getMax();
//                    Toast.makeText(getApplicationContext(),"yoolo"+max.getCount(),Toast.LENGTH_LONG).show();
        if(max.getCount()>0) {
//            max.moveToFirst();
            while (max.moveToNext()) {
                buffer.append("Item Name" + max.getString(1) + "\n");
                buffer.append("Description: " + max.getString(2) + "\n");
                buffer.append("Price per unit: " + max.getString(3) + "\n");
                buffer.append("Quantity: " + max.getString(4) + "\n");
            }
        }
        buffer.append("====Min=====\n");

        Cursor min=mydb.getMin();
        if(min.getCount()>0) {
//            Toast.makeText(getApplicationContext(),"yoolo"+min.getColumnName(3),Toast.LENGTH_LONG).show();

//            min.moveToFirst();
            while (min.moveToNext()) {
                buffer.append("Item Name" + min.getString(1) + "\n");
                buffer.append("Description: " + min.getString(2) + "\n");
                buffer.append("Price per unit: " + min.getString(3) + "\n");
                buffer.append("Quantity: " + min.getString(4) + "\n");
            }
        }
        buffer.append("=====Number==\n");
        buffer.append("Total products with price are:"+num);
        showMessage("Data",buffer.toString());

    }
    public void  showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
