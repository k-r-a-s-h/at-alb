package com.example.database;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText data;
    Button submit,insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new DatabaseHelper(this);
        data=findViewById(R.id.editText);
        submit=findViewById(R.id.submit);
        insert=findViewById(R.id.showdata);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1=data.getText().toString();

                boolean lol=mydb.insertData(data1);
                if(lol)
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Something error", Toast.LENGTH_LONG).show();
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getAllData();
                if(res.getCount()==0){
                    showMessage("Error", "NO data found");

                }
                else{
                    StringBuffer buf=new StringBuffer();
                    while (res.moveToNext()){
                        buf.append("id: "+res.getString(0));
                        buf.append("data: "+res.getString(1)+"\n");
                    }


                    showMessage("Data",buf.toString() );
                }

            }
        });

    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
