package com.example.invoicemachine;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.invoicemachine.MainActivity.mydb;

public class viewinvoice extends AppCompatActivity {
    int total;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewinvoice);
        final Cursor res=mydb.getAllData();
        total=0;
        show=(Button)findViewById(R.id.show_all_database);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Cursor all = mydb.getAllData();
               StringBuffer stringBuffer=new StringBuffer();
               while (all.moveToNext()){
                   stringBuffer.append("ID:"+all.getString(0)+"\n");
                   stringBuffer.append("Item name:"+all.getString(1)+"\n");
                   stringBuffer.append("Description :"+all.getString(2)+"\n");
                   stringBuffer.append("Price Per Unit:"+all.getString(3)+"\n");
                   stringBuffer.append("Quantity: "+all.getString(4)+"\n\n");
               }
               showMessage("Data",stringBuffer.toString());
            }

        });
        if(res.getCount() ==0){
            showMessage("Error","No data found");
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while (res.moveToNext()){
            if(res.getString(1).length()>0 && res.getString(2).length()>0 && res.getString(3).length()>0 && res.getString(4).length()>0){
                buffer.append("Item Name"+res.getString(1)+"\n");
                buffer.append("Description: "+res.getString(2)+"\n");
                buffer.append("Price per unit: "+res.getString(3)+"\n");
                buffer.append("Quantity: "+res.getString(4)+"\n");
                buffer.append("Total: "+Integer.parseInt(res.getString(3))*Integer.parseInt(res.getString(4))+"\n\n");
                total=total+(Integer.parseInt(res.getString(3))* Integer.parseInt(res.getString(4)));
            }
        }
        buffer.append("\nNet Bill:"+total);
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
